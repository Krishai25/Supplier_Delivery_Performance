package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PurchaseOrder {

    private final String orderId;
    private final String supplierId;
    private String materialName;
    private int orderedQuantity;
    private BigDecimal orderValue;
    private LocalDate promisedDate;

    public PurchaseOrder(String orderId, String supplierId, String materialName,
                         int orderedQuantity, BigDecimal orderValue, LocalDate promisedDate) {
        this.orderId = orderId;
        this.supplierId = supplierId;
        this.materialName = materialName;
        this.orderedQuantity = orderedQuantity;
        this.orderValue = orderValue;
        this.promisedDate = promisedDate;
    }

    public String getOrderId() { return orderId; }
    public String getSupplierId() { return supplierId; }

    public String getMaterialName() { return materialName; }
    public void setMaterialName(String materialName) { this.materialName = materialName; }

    public int getOrderedQuantity() { return orderedQuantity; }
    public void setOrderedQuantity(int orderedQuantity) { this.orderedQuantity = orderedQuantity; }

    public BigDecimal getOrderValue() { return orderValue; }
    public void setOrderValue(BigDecimal orderValue) { this.orderValue = orderValue; }

    public LocalDate getPromisedDate() { return promisedDate; }
    public void setPromisedDate(LocalDate promisedDate) { this.promisedDate = promisedDate; }

    @Override
    public String toString() {
        return "PurchaseOrder{orderId='" + orderId + "', supplierId='" + supplierId
                + "', material='" + materialName + "', quantity=" + orderedQuantity
                + ", value=" + orderValue + ", promisedDate=" + promisedDate + "}";
    }
}