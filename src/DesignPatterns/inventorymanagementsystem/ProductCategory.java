package DesignPatterns.inventorymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    private int productCategoryId;
    private List<Product> products;
    private double price;
    private String productCategoryName;

    public ProductCategory() {
        products = new ArrayList<>();
    }

    public ProductCategory(int productCategoryId, List<Product> products, double price, String productCategoryName) {
        this.productCategoryId = productCategoryId;
        this.products = products;
        this.price = price;
        this.productCategoryName = productCategoryName;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public void addProducts(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Product getProductById(int productId) {
        return products.stream().filter(product -> product.getProductId() == productId).findAny().orElse(null);
    }
}
