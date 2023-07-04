package DesignPatterns.inventorymanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private int cartId;
    private Map<Integer, Integer> productVsCountMap;

    public Cart() {
        productVsCountMap = new HashMap<>();
    }

    public Cart(int cartId, Map<Integer, Integer> productVsCountMap) {
        this.cartId = cartId;
        this.productVsCountMap = productVsCountMap;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Map<Integer, Integer> getProductVsCountMap() {
        return productVsCountMap;
    }

    public void setProductVsCountMap(Map<Integer, Integer> productVsCountMap) {
        this.productVsCountMap = productVsCountMap;
    }

    public void addProductToCart(int productCategoryId) {
        productVsCountMap.put(productCategoryId, productVsCountMap.getOrDefault(productCategoryId, 0) + 1);
    }

    public void removeItemFromCart(int productCategoryId, int count) {
        if (!productVsCountMap.containsKey(productCategoryId) || productVsCountMap.get(productCategoryId) < count) {
            return;
        }
        int productsCount = productVsCountMap.get(productCategoryId);
        if (productsCount - count == 0) {
            productVsCountMap.remove(productCategoryId);
        }
        productVsCountMap.put(productCategoryId, productsCount - count);
    }

    public void clearCart() {
        productVsCountMap.clear();
    }
}
