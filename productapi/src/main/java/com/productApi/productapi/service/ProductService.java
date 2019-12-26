package com.productApi.productapi.service;

import java.util.List;

import com.productApi.productapi.model.Product;

public interface ProductService {
	public Integer addProduct(Product product) throws Exception;
	public Product getProductById(Integer id) throws Exception;
	public List<Product> getProducts() throws Exception;
}
