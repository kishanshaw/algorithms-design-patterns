package DesignPatterns.inventorymanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {
    private final Map<Integer, List<Order>> userIdVsOrdersMap;

    public OrderController() {
        userIdVsOrdersMap = new HashMap<>();
    }

    public void addOrder(int userId, Order order) {
        if (userIdVsOrdersMap.containsKey(userId)) {
            List<Order> existingOrders = userIdVsOrdersMap.get(userId);
            existingOrders.add(order);
            userIdVsOrdersMap.put(userId, existingOrders);
        } else {
            List<Order> newOrders = new ArrayList<>();
            newOrders.add(order);
            userIdVsOrdersMap.put(userId, newOrders);
        }
    }

    public void removeOrder(int userId, Order order) {
        if (userIdVsOrdersMap.containsKey(userId)) {
            List<Order> existingOrders = userIdVsOrdersMap.get(userId);
            boolean deletedOrder = existingOrders.remove(order);
            if (!deletedOrder) {
                System.out.println("Order cant be deleted!");
            }
            userIdVsOrdersMap.put(userId, existingOrders);
        }
    }

    public Order createOrder(User user, Map<Integer, Integer> productVsCountMap, Warehouse warehouse) {
        return new Order(warehouse, productVsCountMap, user);
    }
}
