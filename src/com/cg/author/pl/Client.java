package com.cg.author.pl;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.author.bean.Author;

public class Client {
	public static void main(String[] args)
	{
		Scanner src =new Scanner(System.in);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em= emf.createEntityManager();
		
		Author author=new Author();
		int choice=0;
		 while(choice!=6) {
			 em.getTransaction().begin();
			 System.out.println("1.insertAuthor");
			 System.out.println("2.searchAuthor");
			 System.out.println("3.updateAuthor");
			 System.out.println("4.Delete");
			 System.out.println("5.List");
			 System.out.println("6.Exit");
			 System.out.println("enter your choice");
			 choice =src.nextInt();
			 
			 switch(choice) {
			 
			 case 1: System.out.println("enter first name");
	                 String fname= src.next();
	                 System.out.println("enter middle name");
	    	         String mname= src.next();
	    	         System.out.println("enter last name");
	    	         String lname= src.next();
	    	        //ystem.out.println("enter id");
	    	        // int aid=src.nextInt();

	    	         System.out.println("enter phoneno");
	    	         long phoneno=src.nextLong();
	    	         
	    	         author.setFirstName(fname);
	    	         author.setMiddlename(mname);
	    	         author.setLastName(lname);
                     //author.setAuthorId(aid);
                     author.setPhoneNo(phoneno);
                     em.persist(author);
                     break;
                     
			 case 2: System.out.println("enetr your id");
			         int aid=src.nextInt();
			         if(author==null) 
			         {
			        	 System.out.println("author id not found");
			         }
			         else
			         {
			        	 author=em.find(Author.class,aid);
			         }
			 case 3: System.out.println("enter ur id");
			          aid=src.nextInt();
			         author=em.find(Author.class,aid);
			         if(author==null)
			         {
			        	 System.out.println("author id not found");
			         }
			         else
			         {    
			        	 em.merge(author);
			        	 System.out.println(author.getFirstName());
			        	 System.out.println(author.getMiddlename());
			        	 System.out.println(author.getLastName());
						 System.out.println("id found");
			         }
			         break;
			         
			 case 4: System.out.println("enter id"); 
                      aid=src.nextInt();
                      author=em.find(Author.class, aid);
                      if(author==null)
                      {
                    	  System.out.println("author id not found");
                      }
                      else
                      {
                    	  em.remove(author);
                    	  System.out.println("removed");
                      }
                      break;
                      
                      
			 case 5: System.out.println("enter your id");
			           aid=src.nextInt();
                       author=em.find(Author.class, aid);
			           if(author==null) 
			           {
			        	   System.out.println("id not found");
			           }
			           else
			           {
			        	   
			           }
			 
			 
			 case 6: System.out.println("exited sucessfully");  
			         return;
			         
			 }
			 em.getTransaction().commit();
		 }
		 em.close();
		 emf.close();
	}

}
