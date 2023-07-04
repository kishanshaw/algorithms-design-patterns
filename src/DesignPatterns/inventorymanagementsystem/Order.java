package DesignPatterns.inventorymanagementsystem;

import DesignPatterns.bookmyshow.Payment;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Order {
    private final int orderId = ThreadLocalRandom.current().nextInt(1, 1000);

    private final Warehouse warehouse;
    private final Map<Integer, Integer> productVsCountMap;
    private final LocalDateTime orderDateTime = LocalDateTime.now();
    private Location deliveryAddress;
    private OrderStatus orderStatus;
    private User user;
    private Payment payment;
    private double orderAmount;

    private Invoice invoice;

    public Order(Warehouse warehouse, Map<Integer, Integer> productVsCountMap, User user) {
        this.warehouse = warehouse;
        this.productVsCountMap = productVsCountMap;
        this.deliveryAddress = user.getLocation();
        this.orderStatus = OrderStatus.UNDELIVERED;
        this.invoice = new Invoice();
    }

    public Order() {
        warehouse = new Warehouse();
        productVsCountMap = new HashMap<>();
    }

    public double calculateTotalOrderAmount() {
        Inventory inventory = warehouse.getInventory();
        double orderAmount = 0.0;
        for (Map.Entry<Integer, Integer> entry : productVsCountMap.entrySet()) {
            int productCategoryId = entry.getKey();
            double price = inventory.getPriceFroCategory(productCategoryId);
            for (int i = 0; i < entry.getValue(); i++) {
                orderAmount += price;
            }

        }
        return orderAmount;
    }

    public void placeOrder() {
        payment.makePayment();
        invoice.setPayment(payment);
        invoice.generateInvoice();
        if (payment.isDone()) {
            for (Map.Entry<Integer, Integer> entry : productVsCountMap.entrySet()) {
                int productCategoryId = entry.getKey();
                int productsCount = entry.getValue();
                warehouse.getInventory().removeProductsFromCategory(productCategoryId, productsCount);
            }
            user.getCart().clearCart();
            this.orderStatus = OrderStatus.SCHEDULED;
        }
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Map<Integer, Integer> getProductVsCountMap() {
        return productVsCountMap;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOrderId() {
        return orderId;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public Location getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Location deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
