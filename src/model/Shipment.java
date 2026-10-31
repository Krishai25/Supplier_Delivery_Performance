package model;

import java.time.LocalDate;

public class Shipment {

    private final String shipmentId;
    private final String orderId;
    private int deliveredQuantity;
    private LocalDate actualDeliveryDate;
    private String receiptStatus;   // "CONFIRMED" or "DISPUTED"

    public Shipment(String shipmentId, String orderId, int deliveredQuantity,
                    LocalDate actualDeliveryDate, String receiptStatus) {
        this.shipmentId = shipmentId;
        this.orderId = orderId;
        this.deliveredQuantity = deliveredQuantity;
        this.actualDeliveryDate = actualDeliveryDate;
        this.receiptStatus = receiptStatus;
    }

    public String getShipmentId() { return shipmentId; }
    public String getOrderId() { return orderId; }

    public int getDeliveredQuantity() { return deliveredQuantity; }
    public void setDeliveredQuantity(int deliveredQuantity) {
        this.deliveredQuantity = deliveredQuantity;
    }

    public LocalDate getActualDeliveryDate() { return actualDeliveryDate; }
    public void setActualDeliveryDate(LocalDate actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }

    public String getReceiptStatus() { return receiptStatus; }
    public void setReceiptStatus(String receiptStatus) { this.receiptStatus = receiptStatus; }

    @Override
    public String toString() {
        return "Shipment{shipmentId='" + shipmentId + "', orderId='" + orderId
                + "', deliveredQuantity=" + deliveredQuantity
                + ", actualDeliveryDate=" + actualDeliveryDate
                + ", receiptStatus='" + receiptStatus + "'}";
    }
}