package com.niit.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.Product;

@Controller
public class ProductController {
@Autowired
	ProductDao productDao;
   
		
	
	   @RequestMapping(value = "/product", method = RequestMethod.GET)
	   public ModelAndView product(Model model) {
	      ModelAndView mv=new  ModelAndView("Productform", "command", new Product());
	      List<Category> categorylist=productDao.getAllCategory();
	      model.addAttribute("categories",categorylist);
	      return mv;
	   }
	   @RequestMapping(value = "/productlist", method = RequestMethod.GET)
		public String getProductForm(Model model){
			List<Product> plist=productDao.getAllProduct();
			model.addAttribute("prodlist",plist);
			return "Productform";
	   }
	   @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	      public String addProduct(@ModelAttribute("SpringWeb")Product product,HttpServletRequest request,ModelMap model) {
	      
	      model.addAttribute("name", product.getName());
	      model.addAttribute("ID", product.getID());
	      model.addAttribute("price", product.getPrice());
	      model.addAttribute("stock", product.getStock());
	      model.addAttribute("discription", product.getDiscription());
	      productDao.CreateProduct(product);
	      MultipartFile img=product.getImage();
	      System.out.println(request.getServletContext().getRealPath("/"));
	  	
	  	//Defining a path
	  	Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getID()+".jpg");
	  	
	  	//Create a file in the path
	  	
	  	try {
	  		if(img!=null && !img.isEmpty()){
	  		File file=new File(path.toString());
	  		img.transferTo(file);
	  		}
	  	} catch (IllegalStateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  	} catch (IOException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  	}
		List<Product> plist=productDao.getAllProduct();
		model.addAttribute("prodlist",plist);
	      

	      return "Productdisplay";
	   }
	   @RequestMapping(value="/getproduct", method=RequestMethod.GET)
	   public ModelAndView getAllProduct() {
		List<Product> productlist=productDao.getAllProduct();
		ModelAndView mn=new ModelAndView("Productform","command",new Product());
		mn.addObject("prodlist",productlist);
	
		
		return mn;
	}
	   @RequestMapping(value="/deleteproduct")
	   public ModelAndView deleteproduct(@RequestParam int id, Model model) {
	   productDao.DeleteProduct(id);
	   List<Product> plist=productDao.getAllProduct();
		model.addAttribute("prodlist",plist);
		 ModelAndView mv=new  ModelAndView("Productform", "command", new Product());
	      return mv;
	   
   }
	   @RequestMapping(value="/getupdateproduct")
	   public String getUpdateProduct(@RequestParam int id,Model model){
	   	Product product=productDao.getProduct(id);
	   	model.addAttribute("command",product);
	   	List<Category> categerylist=productDao.getAllCategory();
	   	model.addAttribute("categories",categerylist);
	   	return "Updateproductf";
	   }
	   @RequestMapping(value="/updateproduct",method=RequestMethod.POST)
	   public String updateproduct( @ModelAttribute("product")Product product,BindingResult result,ModelMap model,HttpServletRequest request) {
		   if(result.hasErrors()){
			   List<Category> categerylist=productDao.getAllCategory();
			   	model.addAttribute("categeries",categerylist);
			   	return "Updateproductf";
			}
		   productDao.UpdateProduct(product);
		   MultipartFile img=product.getImage();//Defining a path
			Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getID()+".jpg");
			
			//Create a file in the path
			try {
				if(img!=null && !img.isEmpty()){
				File file=new File(path.toString());
				System.out.println(path);
				img.transferTo(file);
				}
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Product> plist=productDao.getAllProduct();
			model.addAttribute("prodlist",plist);
		      
		      return "Productform";
	   }
}

