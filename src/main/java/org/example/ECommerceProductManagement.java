package org.example;

import net.datafaker.Faker;
import org.example.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ECommerceProductManagement {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        String[] categories = {"3C", "家用", "服飾", "食品", "書籍"};
        initializeProduct(productList);
        showLowStockProduct(productList);
        showTargetCategoryProduct("家用",productList);
        istingProducts(productList);
        delistProduct(productList);
    }

    private static void delistProduct(List<Product> productList) {
        Faker faker = new Faker();
        System.out.println("=============下架商品===========");
        if (productList.size() > 0) {
            int randomIndex = faker.random().nextInt(productList.size());
            System.out.println("下架商品" + productList.get(randomIndex));
            productList.remove(randomIndex);
        }
    }

    private static void istingProducts(List<Product> productList) {
        Faker faker = new Faker();
        String[] categories = {"3C", "家用", "服飾", "食品", "書籍"};
        System.out.println("=============上架商品===========");
        for (int i = 0; i < 3; i++) {
            String id = faker.idNumber().valid();
            String name = faker.commerce().productName();
            String category = categories[faker.random().nextInt(categories.length)];
            double price = Double.parseDouble(faker.commerce().price(10, 1000));
            int stock = faker.random().nextInt(0, 100);
            Product product = new Product(id, name, category, price, stock);
            productList.add(product);
            System.out.println("已上架" + product);
        }
    }

    private static void showTargetCategoryProduct(String target,List<Product> productList) {
        System.out.println("=============target===========");
        List<Product> targetCategoryProduct = new ArrayList<>();
        for (Product product : productList) {
            if (product.getCategory().equals(target)) {
                targetCategoryProduct.add(product);
            }
        }
        for (Product product : targetCategoryProduct) {
            System.out.println(product);
        }
    }


    private static List<Product> initializeProduct(List<Product> productList) {
        System.out.println("=========初始商品==========");
        Faker faker = new Faker();
        String[] categories = {"3C", "家用", "服飾", "食品", "書籍"};
        for (int i = 0; i < 30; i++) {
            String id = faker.idNumber().valid();
            String name = faker.commerce().productName();
            String category = categories[faker.random().nextInt(categories.length)];
            double price = Double.parseDouble(faker.commerce().price(10, 1000));
            int stock = faker.random().nextInt(0, 100);
            Product product = new Product(id, name, category, price, stock);
            productList.add(product);
            System.out.println(product);
        }
        return productList;
    }
    private static void showLowStockProduct(List<Product> productList) {
        System.out.println("=========庫存不足==========");
        List<Product> lowStockProduct = new ArrayList<>();
        for (Product product : productList) {
            if (product.getStockQuantity() < 10) {
                lowStockProduct.add(product);
            }
        }
        for (Product product : lowStockProduct) {
            System.out.println(product);
        }
    }
}

