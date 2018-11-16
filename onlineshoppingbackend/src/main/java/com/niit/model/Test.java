package com.niit.model;

import java.sql.*;
public class Test {
	 
	   public static void main(String[] args) throws Exception { 
		
	   
	
	         // STEP 1: Register JDBC driver 
	         Class.forName("org.h2.Driver"); 
	             
	         //STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         Connection conn = DriverManager.getConnection( "jdbc:h2:tcp://localhost/~/test","sa","");  
	         
	         //STEP 3: Execute a query 
	      
	         Statement stmt = conn.createStatement(); 
	         String sql = "drop table bharath";
	           ;  
	         stmt.executeUpdate(sql);
	         System.out.println("Created table in given database..."); 
	         
	         // STEP 4: Clean-up environment 
	         stmt.close(); 
	         conn.close(); 
	    
	         } //end finally try 
	      } //end try 
	  

