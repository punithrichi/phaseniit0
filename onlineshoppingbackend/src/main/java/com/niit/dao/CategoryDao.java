package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.niit.model.Category;
@Repository("categoryDao")
@Transactional
@Service
public interface CategoryDao {

	public void CreateCategory(Category c) ;
		

	public Category ReadCategory(int catId);
	public Category UpdateCategory(Category c);
	public List<Category> getAllCategory();
	public void DeleteCategory(int catId);


	public Category getCategory(int id);
}
