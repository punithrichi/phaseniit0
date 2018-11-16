package com.niit.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Category {
	@Id
private int category_ID;
private String name;
@OneToMany(mappedBy="category")
private List<Product> getproduct;

public List<Product> getGetproduct() {
	return getproduct;
}
public void setGetproduct(List<Product> getproduct) {
	this.getproduct = getproduct;
}
public int getCategory_ID() {
	return category_ID;
}
public void setCategory_ID(int category_ID) {
	this.category_ID = category_ID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
