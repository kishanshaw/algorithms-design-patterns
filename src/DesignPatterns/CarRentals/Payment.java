package DesignPatterns.CarRentals;

public class Payment {
    private final Bill bill;

    public Payment(Bill bill) {
        this.bill = bill;
    }

    public void payBill() {
        bill.setPaid(true);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "bill=" + bill +
                '}';
    }

    public Bill getBill() {
        return bill;
    }
}
