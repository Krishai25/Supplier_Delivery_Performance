# Supplier Delivery Performance and Penalty Management System

A Java console application that evaluates supplier deliveries against each supplier's SLA, identifies late and short deliveries, calculates OTIF (On-Time In-Full) performance, applies capped penalties, and explains every penalty. Built with plain Java, JDBC and MySQL, with a layered design so a web UI can be added later without rewriting the business logic.

> **Status:** In progress. The model layer and the first service are complete. The database schema, DAOs and the remaining services are next.

## Features

- Per-supplier SLA terms: OTIF target, grace period, penalty rate and monthly penalty cap
- Order-level evaluation with split and partial shipments combined
- Deadline calculation using the promised date plus the grace period
- Only confirmed receipts count toward delivered quantity; disputed receipts are held for verification
- Late and short delivery detection
- OTIF calculation, penalty calculation with a monthly cap, holiday and force majeure exemptions, and console reports (planned)

## Business Rules

- Delivery deadline = promised date + grace period (initially 2 days).
- A delivery on the last grace day is on time.
- Short delivery: confirmed quantity is less than the ordered quantity.
- OTIF % = (orders delivered on time and in full / eligible orders) x 100, compared with the 95% target.
- Order penalty = order value x penalty rate.
- Monthly cap = monthly contract value x 5%; final penalty = min(total eligible penalties, cap).
- A short delivery does not automatically attract a penalty; penalty eligibility is configurable.
- Exemptions apply only when the supplier's agreement allows them.

## Tech Stack

- Java (JDK 17 or newer)
- MySQL and JDBC (MySQL Connector/J)
- IntelliJ IDEA, MySQL Workbench
- Git and GitHub
- JUnit (planned)

## Project Structure

```
src/
  Database/   JDBC connection setup
  model/      Supplier, PurchaseOrder, Shipment, OrderEvaluation
  service/    DeliveryEvaluationService
  Main.java   Console entry point (temporary sample data for now)
lib/          MySQL Connector/J jar
```

Planned additions: `CalendarEvent`, the DAO layer, `OTIFService`, `PenaltyService` and `ReportService`.

## Architecture

- **Model:** plain data classes with no business logic.
- **DAO:** JDBC database access (planned).
- **Service:** business logic for evaluation, OTIF, penalties and reporting.
- **Main:** console control flow.

## Getting Started

1. Clone the repository and open it in IntelliJ IDEA.
2. Download MySQL Connector/J, place the jar in `lib/`, and add it under File > Project Structure > Libraries.
3. Create the MySQL database `supply_management` in MySQL Workbench.
4. Update the connection URL, username and password in the connection class. Avoid committing real credentials.
5. Run `Main.java`.

## Sample Output Scenarios

The current `Main` evaluates five sample orders: delivery on the last grace day (on time), one day after (late), a short delivery, a split delivery that completes in time, and a disputed shipment held for verification.

## Roadmap

- [x] Supplier, PurchaseOrder, Shipment and OrderEvaluation models
- [x] DeliveryEvaluationService
- [ ] MySQL schema and sample data
- [ ] DAO layer
- [ ] Holiday and force majeure exemptions
- [ ] OTIFService, PenaltyService and ReportService
- [ ] JUnit tests
- [ ] Web UI
