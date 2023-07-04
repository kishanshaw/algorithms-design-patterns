package DesignPatterns.inventorymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<ProductCategory> productCategories;

    public Inventory() {
        productCategories = new ArrayList<>();
    }

    public Inventory(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public void addProductToCategory(int productCategoryId, Product product) {
        for (ProductCategory productCategory : productCategories) {
            if (productCategory.getProductCategoryId() == productCategoryId) {
                productCategory.getProducts().add(product);
                break;
            }
        }
    }

    public void removeProductsFromCategory(int productCategoryId, int count) {
        for (ProductCategory productCategory : productCategories) {
            if (productCategory.getProductCategoryId() == productCategoryId) {
                List<Product> products = productCategory.getProducts();
                for (int i = 0; i < count; i++) {
                    products.remove(0);
                }
                break;
            }
        }
    }

    public void addProductsToCategory(int productCategoryId, int count) {
        for (ProductCategory productCategory : productCategories) {
            if (productCategory.getProductCategoryId() == productCategoryId) {
                Product product = productCategory.getProducts().stream().findAny().orElse(new Product("productName", 1));
                int id = productCategory.getProducts().size();
                for (int i = 0; i < count; i++) {
                    product.setProductId(++id);
                    productCategory.addProducts(product);
                }
            }
        }
    }

    public void addProductCategory(ProductCategory productCategory) {
        productCategories.add(productCategory);
    }

    public void removeProductCategory(ProductCategory productCategory) {
        productCategories.remove(productCategory);
    }

    public double getPriceFroCategory(int productCategoryId) {
        return productCategories.stream()
                .filter(productCategory -> productCategory.getProductCategoryId() == productCategoryId)
                .map(ProductCategory::getPrice).findAny().orElse(0.0);
    }
}
