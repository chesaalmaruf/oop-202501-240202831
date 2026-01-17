package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public void handleAddProduct(TextField txtCode, TextField txtName, 
                                 TextField txtPrice, TextField txtStock, 
                                 ListView<String> listView) {
        try {
            // Mapping data dari GUI ke Model
            Product p = new Product(
                txtCode.getText(),
                txtName.getText(),
                Double.parseDouble(txtPrice.getText()),
                Integer.parseInt(txtStock.getText())
            );

            service.insert(p); // Panggil service
            listView.getItems().add(p.getCode() + " - " + p.getName() + " (Berhasil Simpan)");
            
            // Bersihkan form
            txtCode.clear(); txtName.clear(); txtPrice.clear(); txtStock.clear();
        } catch (Exception e) {
            listView.getItems().add("Error: " + e.getMessage());
        }
    }
}