package Supply_Mgmt_Main;

import model.*;
import service.DeliveryEvaluationService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Supplier sup = new Supplier("S1", "Test Supplier", new BigDecimal("500000"),
                95.0, 2, new BigDecimal("0.02"), 5.0);
        DeliveryEvaluationService service = new DeliveryEvaluationService();

        LocalDate promised = LocalDate.of(2026, 10, 10);
        BigDecimal value = new BigDecimal("10000");

        // O1: delivered on the last grace day (Oct 12) -> on time
        // O2: delivered Oct 13 -> late
        // O3: only 90 of 100 confirmed -> short
        // O4: split 50 + 50, completed Oct 11 -> OTIF
        // O5: only a disputed shipment -> short, held for verification
        PurchaseOrder o1 = new PurchaseOrder("O1", "S1", "Steel", 100, value, promised);
        PurchaseOrder o2 = new PurchaseOrder("O2", "S1", "Copper", 100, value, promised);
        PurchaseOrder o3 = new PurchaseOrder("O3", "S1", "Brass", 100, value, promised);
        PurchaseOrder o4 = new PurchaseOrder("O4", "S1", "Zinc", 100, value, promised);
        PurchaseOrder o5 = new PurchaseOrder("O5", "S1", "Tin", 100, value, promised);

        List<Shipment> shipments = List.of(
                new Shipment("SH1", "O1", 100, LocalDate.of(2026, 10, 12), "CONFIRMED"),
                new Shipment("SH2", "O2", 100, LocalDate.of(2026, 10, 13), "CONFIRMED"),
                new Shipment("SH3", "O3", 90, LocalDate.of(2026, 10, 10), "CONFIRMED"),
                new Shipment("SH4", "O4", 50, LocalDate.of(2026, 10, 9), "CONFIRMED"),
                new Shipment("SH5", "O4", 50, LocalDate.of(2026, 10, 11), "CONFIRMED"),
                new Shipment("SH6", "O5", 100, LocalDate.of(2026, 10, 10), "DISPUTED"));

        for (PurchaseOrder o : List.of(o1, o2, o3, o4, o5)) {
            System.out.println(service.evaluate(o, sup, shipments));
        }
    }
}