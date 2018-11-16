package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Category;
import com.niit.model.Product;
@Repository("productDao")
public interface ProductDao {

	public   void CreateProduct(Product p) ;
	public Product ReadProduct(int ProId);
	public Product UpdateProduct(Product p);
	public void DeleteProduct(int ProId);
	public List<Product> getAllProduct();
	public List<Category> getAllCategory();
	public Product getProduct(int productID);
}
