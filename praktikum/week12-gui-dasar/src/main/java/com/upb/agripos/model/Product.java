package com.upb.agripos.model;

public class Product {
    private final String code; // Dijadikan final sesuai saran IDE
    private String name;
    private double price;
    private int stock;

    public Product(String code, String name, double price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return String.format("| %-7s | %-25s | %-12.2f | %-7d |", 
                             code, name, price, stock);
    }
}