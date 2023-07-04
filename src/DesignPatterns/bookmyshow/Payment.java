package DesignPatterns.bookmyshow;

public class Payment {
    private int paymentId;
    private boolean isDone;

    public Payment() {

    }

    public Payment(int paymentId, boolean isDone) {
        this.paymentId = paymentId;
        this.isDone = isDone;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void makePayment() {
        this.setDone(true);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", isDone=" + isDone +
                '}';
    }
}
