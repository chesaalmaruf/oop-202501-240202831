package com.upb.agripos;

import java.sql.Connection;
import java.sql.DriverManager;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductFormView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // 1. Koneksi Database
        Connection conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/agripos", 
            "postgres", 
            "admin123" // Sesuaikan di sini
        );
        // 2. Dependency Injection
        ProductDAOImpl dao = new ProductDAOImpl(conn);
        ProductService service = new ProductService(dao);
        ProductController controller = new ProductController(service);
        ProductFormView view = new ProductFormView(controller);
        
        primaryStage.setTitle("Agri-POS - Bab 12 GUI Dasar");
        primaryStage.setScene(new Scene(view.asParent(), 400, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}