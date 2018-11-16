package com.niit.Daoimplements;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl  implements SupplierDao{
	 
 
	@Autowired
	    private SessionFactory sessionFactory;
	  
	public void CreateSupplier(Supplier s) {
		 sessionFactory.getCurrentSession().saveOrUpdate(s);
		
	}

	public Supplier ReadSupplier(int SupId) {
		return (Supplier) sessionFactory.getCurrentSession().get(
                Supplier.class, SupId);
	}

	public Supplier UpdateSupplier(Supplier s) {
		 sessionFactory.getCurrentSession().update(s);
	        return s;
	}

	public void DeleteSupplier(int SupId) {
		Supplier supplier = (Supplier) sessionFactory.getCurrentSession().load(
                Supplier.class, SupId);
        if (null != supplier) {
            this.sessionFactory.getCurrentSession().delete(supplier);
        }
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> getAllSupplier() {
		   return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
		
	}

	@Override
	public Supplier getSupplier(int id) {
		return (Supplier) sessionFactory.getCurrentSession().get(
				Supplier.class, id);
	}

}
