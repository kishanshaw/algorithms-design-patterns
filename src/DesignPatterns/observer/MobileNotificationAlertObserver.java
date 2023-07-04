package DesignPatterns.observer;

public class MobileNotificationAlertObserver implements NotificationAlertObserver {
    private final StockObservable stockObservable;
    private final String userName;

    public MobileNotificationAlertObserver(String userName, StockObservable stockObservable) {
        this.stockObservable = stockObservable;
        this.userName = userName;
    }

    @Override
    public void update() {
        sendSmsOnMobile(userName);
    }

    private void sendSmsOnMobile(String userName) {
        System.out.println(userName + " hurry up, the stock of " + this.stockObservable.productName() + " is available now!");
    }
}
