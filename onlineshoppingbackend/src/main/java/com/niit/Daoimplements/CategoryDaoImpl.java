package com.niit.Daoimplements;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	 @Autowired
	    private SessionFactory sessionFactory;
	 
	public void CreateCategory(Category c) {
	
		sessionFactory.getCurrentSession().saveOrUpdate(c);
	}

	public Category ReadCategory(int catId) {
		return (Category) sessionFactory.getCurrentSession().get(
                Category.class, catId);
		
	}

	public Category UpdateCategory(Category c) {
		 sessionFactory.getCurrentSession().update(c);
	        return c;
		
	}
	 @SuppressWarnings("unchecked")
	public List<Category> getAllCategory() {
		 return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public void DeleteCategory(int catId) {
		Category category = (Category) sessionFactory.getCurrentSession().load(
                Category.class, catId);
        if (null != category) {
            this.sessionFactory.getCurrentSession().delete(category);
        }
 
		
	}

	@Override
	public Category getCategory(int id) {
		return (Category) sessionFactory.getCurrentSession().get(
                Category.class, id);
		
	}
}