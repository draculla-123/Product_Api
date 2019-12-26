package com.productApi.productapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.productApi.productapi.dao.ProductDAO;
import com.productApi.productapi.model.Product;


@Service(value="productService")
@Transactional(readOnly=true)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public Integer addProduct(Product product) throws Exception {
		Integer productId = null ;
		productId= productDAO.addProduct(product);
		return productId;
	}

	@Override
	public Product getProductById(Integer id) throws Exception {
		Product product= null ;	
		product= productDAO.getProductById(id);
		return product;
	}

	@Override
	public List<Product> getProducts() throws Exception {
		List<Product> products = null ;
		products= productDAO.getProducts();
		if (products.isEmpty()) {
			throw new Exception("No product is registered with us");
		}
		return products;
	}
}