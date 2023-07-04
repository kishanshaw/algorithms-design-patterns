package DesignPatterns.observer;

public class EmailNotificationAlertObserver implements NotificationAlertObserver {
    private final String emailId;
    private final StockObservable stockObservable;

    public EmailNotificationAlertObserver(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendEmail(emailId, stockObservable);
    }

    private void sendEmail(String emailId, StockObservable stockObservable) {
        System.out.println(emailId + " , hurry up the stock of " + stockObservable.productName() + " is available now!");
    }
}
