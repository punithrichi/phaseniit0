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

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.dao.CategoryDao;
@Controller
public class CategoryController {
@Autowired
CategoryDao categoryDao;
	

	
	   @RequestMapping(value = "/category", method = RequestMethod.GET)
	   public ModelAndView categery() {
	      return new ModelAndView("Categoryform", "command", new Category());
	   }
	   @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	      public String addCategory(@ModelAttribute("SpringWeb")Category category, ModelMap model) {
	      System.out.println(category.getName());
	      model.addAttribute("name", category.getName());
	      model.addAttribute("id", category.getCategory_ID());
	      categoryDao.CreateCategory(category);
	      return "Categorydisplay";
	   }
	   @RequestMapping(value="/getcategory", method=RequestMethod.GET)
	   public ModelAndView getAllProduct() {
		List<Category> categorylist=categoryDao.getAllCategory();
		ModelAndView mn=new ModelAndView("Categoryform","command",new Category());
		mn.addObject("catlist",categorylist);
		return mn;
	}
	   @RequestMapping(value="/deletecategory")
	   public String deletecategory(@RequestParam int id, Model model) {
	   categoryDao.DeleteCategory(id);
	   List<Category> categorylist=categoryDao.getAllCategory();
		model.addAttribute("catlist",categorylist);
	      
	      return "redirect:/getcategory";
   }
	   @RequestMapping(value="/getupdatecategory")
	   public String getUpdateCategory(@RequestParam("id") int id,Model model){
	   	Category category=categoryDao.getCategory(id);
	   	model.addAttribute("command",category);
	   	List<Category> categorylist=categoryDao.getAllCategory();
	   	model.addAttribute("catlist",categorylist);
	   	return "Updatecategeryf";
	   }
	   @RequestMapping(value="/Updatecategery",method=RequestMethod.POST)
	   public String updatecategery( @ModelAttribute("category")Category category,BindingResult result,ModelMap model) {
		/*   if(result.hasErrors()){
		   List<Category> categerylist=categoryDao.getAllCategory();
		   	model.addAttribute("catlist",categerylist);
		   	return "Updatecategeryf";
			}*/
		   categoryDao.UpdateCategory(category);
			List<Category> categorylist=categoryDao.getAllCategory();
			model.addAttribute("catlist",categorylist);
		      return "Categorydisplay";
	   }
	}


