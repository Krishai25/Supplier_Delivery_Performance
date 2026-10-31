package model;

import java.math.BigDecimal;

public class Supplier {

    private final String supplierId;
    private String supplierName;
    private BigDecimal monthlyValue;
    private double otifTarget;            // percentage, e.g. 95.0
    private int gracePeriodDays;          // e.g. 2
    private BigDecimal penaltyRate;       // fraction of order value, e.g. 0.02 = 2%
    private double penaltyCapPercentage;  // percentage of monthly value, e.g. 5.0

    public Supplier(String supplierId, String supplierName, BigDecimal monthlyValue,
                    double otifTarget, int gracePeriodDays,
                    BigDecimal penaltyRate, double penaltyCapPercentage) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.monthlyValue = monthlyValue;
        this.otifTarget = otifTarget;
        this.gracePeriodDays = gracePeriodDays;
        this.penaltyRate = penaltyRate;
        this.penaltyCapPercentage = penaltyCapPercentage;
    }

    public String getSupplierId() { return supplierId; }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }

    public BigDecimal getMonthlyValue() { return monthlyValue; }
    public void setMonthlyValue(BigDecimal monthlyValue) { this.monthlyValue = monthlyValue; }

    public double getOtifTarget() { return otifTarget; }
    public void setOtifTarget(double otifTarget) { this.otifTarget = otifTarget; }

    public int getGracePeriodDays() { return gracePeriodDays; }
    public void setGracePeriodDays(int gracePeriodDays) { this.gracePeriodDays = gracePeriodDays; }

    public BigDecimal getPenaltyRate() { return penaltyRate; }
    public void setPenaltyRate(BigDecimal penaltyRate) { this.penaltyRate = penaltyRate; }

    public double getPenaltyCapPercentage() { return penaltyCapPercentage; }
    public void setPenaltyCapPercentage(double penaltyCapPercentage) {
        this.penaltyCapPercentage = penaltyCapPercentage;
    }

    @Override
    public String toString() {
        return "Supplier{id='" + supplierId + "', name='" + supplierName
                + "', monthlyValue=" + monthlyValue
                + ", otifTarget=" + otifTarget + "%"
                + ", gracePeriodDays=" + gracePeriodDays
                + ", penaltyRate=" + penaltyRate
                + ", penaltyCapPercentage=" + penaltyCapPercentage + "%}";
    }
}