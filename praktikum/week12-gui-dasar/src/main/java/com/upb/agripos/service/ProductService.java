package com.upb.agripos.service;

import java.util.List;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;

public class ProductService {
    private final ProductDAO dao;

    public ProductService(ProductDAO dao) {
        this.dao = dao;
    }

    public void insert(Product p) throws Exception {
        // Logika bisnis: validasi data sebelum masuk ke DAO
        if (p.getPrice() < 0) throw new Exception("Harga tidak boleh negatif!");
        dao.insert(p);
    }

    public List<Product> findAll() throws Exception {
        return dao.findAll();
    }
}