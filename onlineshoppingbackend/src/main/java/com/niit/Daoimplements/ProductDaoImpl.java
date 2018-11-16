package com.niit.Daoimplements;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
 
	@Autowired
    private SessionFactory sessionFactory;
    
	public void CreateProduct(Product p) {
		 sessionFactory.getCurrentSession().saveOrUpdate(p);
	}

	public Product ReadProduct(int ProId) {
		 return (Product) sessionFactory.getCurrentSession().get(
	                Product.class, ProId);
	}

	public Product UpdateProduct(Product p) {
		sessionFactory.getCurrentSession().update(p);
        return p;
	
	}

	public void DeleteProduct(int ProId) {
		 Product product = (Product) sessionFactory.getCurrentSession().load(
	                Product.class, ProId);
	        if (null != product) {
	            this.sessionFactory.getCurrentSession().delete(product);
	        }
		
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() {
		 return sessionFactory.getCurrentSession().createQuery("from Product").list();

	}

	@Override
	public List<Category> getAllCategory() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();

	}

	@Override
	public Product getProduct(int productID) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productID);
	}
	}
