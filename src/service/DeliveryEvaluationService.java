package service;

import model.OrderEvaluation;
import model.PurchaseOrder;
import model.Shipment;
import model.Supplier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DeliveryEvaluationService {

    private static final String CONFIRMED = "CONFIRMED";
    private static final String DISPUTED = "DISPUTED";

    public LocalDate calculateDeadline(PurchaseOrder order, Supplier supplier) {
        return order.getPromisedDate().plusDays(supplier.getGracePeriodDays());
    }

    public OrderEvaluation evaluate(PurchaseOrder order, Supplier supplier,
                                    List<Shipment> shipments) {
        LocalDate deadline = calculateDeadline(order, supplier);

        List<Shipment> confirmed = new ArrayList<>();
        int disputedQuantity = 0;
        for (Shipment s : shipments) {
            if (!s.getOrderId().equals(order.getOrderId())) continue;
            if (CONFIRMED.equalsIgnoreCase(s.getReceiptStatus())) {
                confirmed.add(s);
            } else if (DISPUTED.equalsIgnoreCase(s.getReceiptStatus())) {
                disputedQuantity += s.getDeliveredQuantity();
            }
        }
        confirmed.sort(Comparator.comparing(Shipment::getActualDeliveryDate));

        int confirmedQuantity = 0;
        LocalDate completionDate = null;
        LocalDate lastDate = null;
        for (Shipment s : confirmed) {
            confirmedQuantity += s.getDeliveredQuantity();
            lastDate = s.getActualDeliveryDate();
            if (completionDate == null && confirmedQuantity >= order.getOrderedQuantity()) {
                completionDate = lastDate;
            }
        }

        boolean shortDelivery = confirmedQuantity < order.getOrderedQuantity();
        LocalDate deliveryDate = (completionDate != null) ? completionDate : lastDate;
        boolean late = deliveryDate != null && deliveryDate.isAfter(deadline);

        return new OrderEvaluation(order, deadline, confirmedQuantity,
                disputedQuantity, deliveryDate, late, shortDelivery);
    }
}