package com.upb.agripos.view;

import com.upb.agripos.controller.ProductController;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ProductFormView {
    private final ProductController controller;

    public ProductFormView(ProductController controller) {
        this.controller = controller;
    }

    public Parent asParent() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        // Form Fields
        TextField txtCode = new TextField(); txtCode.setPromptText("Kode Produk");
        TextField txtName = new TextField(); txtName.setPromptText("Nama Produk");
        TextField txtPrice = new TextField(); txtPrice.setPromptText("Harga");
        TextField txtStock = new TextField(); txtStock.setPromptText("Stok");
        
        Button btnAdd = new Button("Tambah Produk");
        ListView<String> listView = new ListView<>();

        // Event Handling
        btnAdd.setOnAction(event -> controller.handleAddProduct(
            txtCode, txtName, txtPrice, txtStock, listView
        ));

        root.getChildren().addAll(
            new Label("Form Input Produk Agri-POS"),
            txtCode, txtName, txtPrice, txtStock, 
            btnAdd, new Label("Daftar Aktivitas:"), listView
        );

        return root;
    }
}