package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Controller
public class HomeController {
	@Autowired
	CategoryDao categoryDao;
public HomeController(){
	System.out.println("homeController bean is created");
}

@RequestMapping(value="/home")
public String getHomePage(Model model){
List<Category> categorylist=categoryDao.getAllCategory();
model.addAttribute("catlist",categorylist);
	return "home";
}
@RequestMapping("/login")
public String login(){
	return "login";
}
@RequestMapping("/loginerror")
public String loginError(Model model){
	model.addAttribute("loginError","Invalid email/password");
	return "login";
}
@RequestMapping(value="/logout")
public String logout(Model model){
	model.addAttribute("message","Loggedout successfully..");
	return "login";
}



}

