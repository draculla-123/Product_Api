package com.productApi.productapi.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.productApi.productapi.entity.ProductEntity;
import com.productApi.productapi.model.Product;

@Repository(value = "productDAO")
public class ProductDAOImpl implements ProductDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Integer addProduct(Product product) throws Exception {
		Integer productId=null;

		ProductEntity entity=new ProductEntity();
		//Setting all the values of the product in the entity
		entity.setProductName(product.getProductName());
		entity.setProductDesc(product.getProductDesc());
		entity.setQuantity(product.getQuantity());
		entity.setPrice(product.getPrice());
		//Commiting the transaction
		entityManager.persist(entity);

		productId=entity.getProductId();		
		return productId;
	}

	@Override
	public Product getProductById(Integer id) throws Exception {
		Product product=null;	
		ProductEntity productEntity = entityManager.find(ProductEntity.class, id);
		if(productEntity!=null){
			product=new Product();
			product.setPrice(productEntity.getPrice());
			product.setQuantity(productEntity.getQuantity());
			product.setProductName(productEntity.getProductName());
			product.setProductDesc(productEntity.getProductDesc());
			product.setProductId(productEntity.getProductId());
		}
		
		return product;
	}

	@Override
	public List<Product> getProducts() throws Exception {
		Query q = entityManager.createQuery("SELECT p FROM ProductEntity p");
		List<ProductEntity> productsEntity = q.getResultList();
		
		List<Product> products = new ArrayList<Product>();
		for (ProductEntity productEntity:productsEntity) {
			Product product = new Product();
			product.setProductId(productEntity.getProductId());
			product.setProductName(productEntity.getProductName());
			product.setProductDesc(productEntity.getProductDesc());
			product.setQuantity(productEntity.getQuantity());
			product.setPrice(productEntity.getPrice());

			products.add(product);
		}
		
		return products;
		
	}


	

}
