package DesignPatterns.inventorymanagementsystem;

import DesignPatterns.bookmyshow.Payment;

public class Invoice {
    private int invoiceId;
    private Payment payment;
    private Order order;

    public Invoice() {
        payment = new Payment();
    }

    public Invoice(int invoiceId, Payment payment, Order order) {
        this.invoiceId = invoiceId;
        this.payment = payment;
        this.order = order;
    }

    public void generateInvoice() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", payment=" + payment +
                ", order=" + order.getOrderId() +
                '}';
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
