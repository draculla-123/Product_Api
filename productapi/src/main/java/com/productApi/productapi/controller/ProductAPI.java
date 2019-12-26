package com.productApi.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.productApi.productapi.model.Product;
import com.productApi.productapi.service.ProductService;

@RestController
public class ProductAPI {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/getAllProductDetails", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProductDetails() throws Exception {
		List<Product> productList = productService.getProducts();
		ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/getProductDetails/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductDetails(@PathVariable Integer productId)  throws Exception  {
		Product product= productService.getProductById(productId);
		ResponseEntity<Product> response = new ResponseEntity<Product>(product, HttpStatus.OK);
		return response;
	}
	
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ResponseEntity<String> addProduct(@RequestBody Product product) throws Exception  {
    	Integer productId = productService.addProduct(product);
		String successMessage = "Product added successfully with id: "+productId;
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
}