package storemanagerproducer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class StoreManager{
	  private int pNo;
	  private String pType;
	  private String pQuantity;
	  private String pPrice;
	  private String a;

	  StoreManager(int pNo, String pType, String pQuantity, String pPrice, String a){
		 this.pNo = pNo;
	     this.pType = pType;
	     this.pQuantity = pQuantity;
	     this.pPrice = pPrice;
	     this.a = a;
	  }
	  public int getpNo(){
		     return pNo;
		  }

	  public String getpType(){
	     return pType;
	  }
	  
	  public String getpQuantity(){
	     return pQuantity;
	  }
	  
	  public String getpPrice(){
		     return pPrice;
		  }
	  

	  public String toString(){
	     return pNo+" "+pType+" "+pQuantity+" "+pPrice+" "+a;
	  }
	}



public class StoreManagerProducerImpl implements StoreManagerProducerInf {
	  ArrayList<StoreManager> u = new ArrayList<StoreManager>();
	     Scanner scanner = new Scanner(System.in);
	     Scanner scanner1 = new Scanner(System.in);

	
		@Override
		public  void addProducts(){
			System.out.print("Enter Product No: ");
			   int pNo = scanner.nextInt();
			   System.out.print("Enter Product Name (Fertilizer/Seed) : ");
			   String pType = scanner1.nextLine();
	           System.out.print("Enter Product Quantity : ");
	           String pQuantity = scanner.next();
	           double B = Double.parseDouble(pQuantity);
	           System.out.print("Enter Price per 1KG : ");
	           String pPrice = scanner.next();
	           double C = Double.parseDouble(pPrice);
	           double pTotal = B*C;
	           String a = Double.toString(pTotal);
	   		u.add(new StoreManager(pNo,"\n"+"1- Product Type : \t"+pType,"\n"+"2- Product Quantity : \t"+pQuantity,"KG"+"\n"+"3- Product Price : \t"+"Rs."+pPrice,"\n"+"4- Total price : \t"+"Rs."+a));
			System.out.println("\n"+"-----Successfully added the product!-----"+"\n");
		}
		
		@Override
		public void displayProductList() {
			 System.out.println("------------------------------");
				
	          Iterator<StoreManager> i = u.iterator();
	          while(i.hasNext()){
	        	  StoreManager e = i.next(); 
	             System.out.println(e);
	             
	          }
	          System.out.println("------------------------------");
	}
		public void Search() {
			   boolean found = false;
	           System.out.print("Enter Product Number to Search :");
	           int pNo = scanner.nextInt();
	           Iterator<StoreManager> i = u.iterator();
	           System.out.println("------------------------------");
	           i = u.iterator();
	           while(i.hasNext()){
	        	   StoreManager e = i.next();
	              if(e.getpNo() == pNo)  {
	                 System.out.println(e);
	                 found = true;
	              }
	           }
	           
	           if(!found){
	              System.out.println("Record Not Found");
	           }
	           System.out.println("------------------------------");
		}
		public void Delete() {
	        boolean found = false;
	        System.out.print("Enter Product Number to Delete :");
	        int pNo = scanner.nextInt();
	        Iterator<StoreManager> i = u.iterator();
	        System.out.println("------------------------------");
	        i = u.iterator();
	        while(i.hasNext()){
	        	StoreManager e = i.next();
	           if(e.getpNo() == pNo)  {
	              i.remove();
	              found = true;
	           }
	        }
	        
	        if(!found){
	           System.out.println("Record Not Found");
	        }else{
	           System.out.println("\n"+"=====Suceesfully deleted the record!====="+"\n");
	        }

	        System.out.println("------------------------------");
		}
		public void Update() {
	        boolean found = false;
	        System.out.print("Enter Product Number to Update :");
	        int pNo = scanner.nextInt();
	        ListIterator<StoreManager> li = u.listIterator();
	        while(li.hasNext()){
	        	StoreManager e = li.next();
	           if(e.getpNo() == pNo)  {
	              System.out.print("Enter new Product type : ");
	              String pType = scanner1.next();
	              System.out.print("Enter new Product Quantity : ");
	              String pQuantity = scanner.next();
	              double B = Double.parseDouble(pQuantity);
	              System.out.print("Enter new Product Price : ");
	              String pPrice = scanner.next();
	              double C = Double.parseDouble(pPrice);
		          double pTotal = B*C;
		          String a = Double.toString(pTotal);
		           
	              li.set(new StoreManager(pNo,"\n"+"1- Product Type : \t"+pType,"\n"+"2- Product Quantity : \t"+pQuantity,"KG"+"\n"+"3- Product Price : \t"+"Rs."+pPrice,"\n"+"4- Total price : \t"+"Rs."+a));
	              found = true;
	           }
	        }
	        
	        if(!found){
	           System.out.println("Record Not Found");
	        }else{
	           System.out.println("\n"+ "----Successfully updated the record!----"+"\n");
	        }
		}
	}



