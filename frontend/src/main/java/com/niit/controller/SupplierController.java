package com.niit.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	SupplierDao supplierDao;
	
	   @RequestMapping(value = "/supplier", method = RequestMethod.GET)
	   public ModelAndView customer() {
	      return new ModelAndView("Supplierform", "command", new Supplier());
	   }
	   @RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	      public String addCustomer(@ModelAttribute("SpringWeb")Supplier supplier, 
	   
	   ModelMap model) {
	      
	      model.addAttribute("name", supplier.getName());
	      model.addAttribute("ID", supplier.getID());
	      model.addAttribute("contact", supplier.getContact());
	      model.addAttribute("details", supplier.getDetails());
		  supplierDao.CreateSupplier(supplier);
	      return "Supplierdisplay";
	   }
	   @RequestMapping(value="/getsupplier", method=RequestMethod.GET)
	   public ModelAndView getAllSupplier() {
		List<Supplier> supplierlist=supplierDao.getAllSupplier();
		ModelAndView mn=new ModelAndView("Supplierform","command",new Supplier());
		mn.addObject("suplist",supplierlist);
		return mn;
	}
	   @RequestMapping(value="/deletesupplier")
	   public String deletesupplier(@RequestParam int id, Model model) {
	   supplierDao.DeleteSupplier(id);
	   List<Supplier> supplierlist=supplierDao.getAllSupplier();
		model.addAttribute("catlist",supplierlist);
	      
	      return "redirect:/getsupplier";
	}
	   
	   @RequestMapping(value="/getupdatesupplier")
	   public String getUpdateSupplier(@RequestParam("id") int id,Model model){
		   Supplier supplier=supplierDao.getSupplier(id);
	   	model.addAttribute("command",supplier);
	   	List<Supplier> supplierlist=supplierDao.getAllSupplier();
	   	model.addAttribute("catlist",supplierlist);
	   	return "Updatesupplierf";
	   }
	   @RequestMapping(value="/Updatesupplier",method=RequestMethod.POST)
	   public String updatesupplier( @ModelAttribute("supplier")Supplier supplier,BindingResult result,ModelMap model) {
		/*   if(result.hasErrors()){
		   List<Supplier> supplierlist=supplierDao.getAllSupplier();
			model.addAttribute("catlist",supplierlist);
		   	return "Updatecategeryf";
			}*/
		   supplierDao.UpdateSupplier(supplier);
			List<Supplier> supplierlist=supplierDao.getAllSupplier();
			model.addAttribute("suplist",supplierlist);
		      return "redirect:/getsupplier";
	   }
	   }


