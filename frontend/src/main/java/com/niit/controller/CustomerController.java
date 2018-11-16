package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.CustomerDao;
import com.niit.model.Customer;


@Controller
public class CustomerController {
	@Autowired
  private CustomerDao customerDao;
	
	
	@RequestMapping(value="/customer")
	public String getRegistrationForm(Model model){
	Customer customer	=new Customer();
	model.addAttribute("customer",customer);	
	return "registration";	
	}
	@RequestMapping(value="/all/registercustomer",method=RequestMethod.POST)
	public String registerCustomer(@ModelAttribute("customer") Customer customer,Model model){
		String email=customer.getUser().getEmail();
		if(!customerDao.isEmailUnique(email)){//Email is duplicate, Not Unique
			model.addAttribute("errorMessage","Email already exists.. please choose different email id");
			return "registrationform";
		}
		customerDao.registerCustomer(customer);
		
		return "login";
	}
}

