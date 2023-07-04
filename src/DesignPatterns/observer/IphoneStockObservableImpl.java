package DesignPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservableImpl implements StockObservable {
    private final List<NotificationAlertObserver> observers = new ArrayList<>();
    private int stockCount = 0;
    private String productName;

    @Override
    public void add(NotificationAlertObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        observers.forEach(NotificationAlertObserver::update);
    }

    @Override
    public String productName() {
        return "iPhone";
    }

    public int getStockCount() {
        return this.stockCount;
    }

    @Override
    public void setStockCount(int stockCount) {
        if (this.stockCount == 0) {
            notifySubscribers();
        }
        this.stockCount += stockCount;
    }

    public String getProductName() {
        return this.productName;
    }
}
