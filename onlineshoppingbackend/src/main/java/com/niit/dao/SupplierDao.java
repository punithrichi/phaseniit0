package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Category;
import com.niit.model.Supplier;
@Repository("supplierDao")
public interface SupplierDao {

	public void CreateSupplier(Supplier s);
	public Supplier ReadSupplier(int SupId);
	public Supplier UpdateSupplier(Supplier s);
	public void DeleteSupplier(int SupId);
	public List<Supplier> getAllSupplier();
	public Supplier getSupplier(int id);
	
	
}
