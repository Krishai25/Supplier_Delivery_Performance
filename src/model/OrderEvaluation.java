package model;

import java.time.LocalDate;

public class OrderEvaluation {

    private final PurchaseOrder order;
    private final LocalDate deadline;
    private final int confirmedQuantity;
    private final int disputedQuantity;
    private final LocalDate deliveryDate;   // null if nothing confirmed
    private final boolean late;
    private final boolean shortDelivery;

    public OrderEvaluation(PurchaseOrder order, LocalDate deadline, int confirmedQuantity,
                           int disputedQuantity, LocalDate deliveryDate,
                           boolean late, boolean shortDelivery) {
        this.order = order;
        this.deadline = deadline;
        this.confirmedQuantity = confirmedQuantity;
        this.disputedQuantity = disputedQuantity;
        this.deliveryDate = deliveryDate;
        this.late = late;
        this.shortDelivery = shortDelivery;
    }

    public PurchaseOrder getOrder() { return order; }
    public LocalDate getDeadline() { return deadline; }
    public int getConfirmedQuantity() { return confirmedQuantity; }
    public int getDisputedQuantity() { return disputedQuantity; }
    public LocalDate getDeliveryDate() { return deliveryDate; }
    public boolean isLate() { return late; }
    public boolean isShortDelivery() { return shortDelivery; }
    public boolean isHeldForVerification() { return disputedQuantity > 0; }
    public boolean isOnTimeInFull() { return !late && !shortDelivery; }

    @Override
    public String toString() {
        return "OrderEvaluation{order=" + order.getOrderId() + ", deadline=" + deadline
                + ", confirmed=" + confirmedQuantity + ", disputed=" + disputedQuantity
                + ", deliveryDate=" + deliveryDate + ", late=" + late
                + ", short=" + shortDelivery + "}";
    }
}