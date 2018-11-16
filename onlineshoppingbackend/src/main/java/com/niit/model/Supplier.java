package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {
	
	@Id
private int ID;	

private String name;
private String details;
private int contact;
public int getContact() {
	return contact;
}
public void setContact(int contact) {
	this.contact = contact;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}

public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
}
