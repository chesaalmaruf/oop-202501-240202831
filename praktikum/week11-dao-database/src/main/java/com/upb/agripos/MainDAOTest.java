package com.upb.agripos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;

public class MainDAOTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/agripos";
        String user = "postgres";
        String pass = "admin123"; 

        // Menggunakan try-with-resources sesuai saran hint IDE
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            ProductDAO dao = new ProductDAOImpl(conn);

            // Operasi CRUD
            dao.insert(new Product("P03", "Pupuk kandang", 25000, 10));
            dao.update(new Product("P03", "Pupuk kandang Premium ", 30000, 8));
            dao.insert(new Product("P04", "Bibit kangkung", 15000, 50));

            // Mencetak Header Tabel
            printHeader();

            // Mengambil semua data dan mencetaknya secara detail
            List<Product> products = dao.findAll();
            for (Product p : products) {
                System.out.println(p);
            }
            
            printFooter();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


    private static void printHeader() {
        System.out.println("i'm chesa salsabil al'ma'ruf - NIM: 240202831");
        System.out.println("\n" + "=".repeat(60));
        System.out.printf("| %-7s | %-25s | %-12s | %-7s |\n", "KODE", "NAMA PRODUK", "HARGA", "STOK");
        System.out.println("-".repeat(60));
    }
        

        
    private static void printFooter() {
        System.out.println("=".repeat(60));
    }
}