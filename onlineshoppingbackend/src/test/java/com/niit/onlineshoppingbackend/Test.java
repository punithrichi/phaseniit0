package com.niit.onlineshoppingbackend;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;
 
public class Test {
	
	
	public static void main(String args[]){
		
	

@SuppressWarnings("resource")
AnnotationConfigApplicationContext config =new AnnotationConfigApplicationContext();
 config.scan("com.niit.*");
 config.refresh();
 Category category=(Category) config.getBean("category");
CategoryDao categorydao=(CategoryDao) config.getBean("categorydao");
category.setCategory_ID(1);
category.setName("abc");
 categorydao.CreateCategory(category);
	}
}
