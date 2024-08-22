package storagedetailproducer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StorageDetailProducerImpl implements StorageDetailProducerInf{
	Scanner sc;
	String newquantity;
	HashMap<String, String> withVegetable = new HashMap<String, String>();
	HashMap<String,String> withFruit = new HashMap<String, String>();
	HashMap<String, String> withGreenery = new HashMap<String, String>();
	
	public StorageDetailProducerImpl() {
		withVegetable.put("Carrot ","10Kg");
		withVegetable.put("Cabbage","20Kg");
		withVegetable.put("Potatoe","15Kg");
		withFruit.put("Guava","50Kg");
		withFruit.put("Melon","120Kg");
		withGreenery.put("Gotukola","800g" );
		withGreenery.put("Spinach ","500g" );
		
		sc = new Scanner(System.in);
	}
	
	
	@Override
	public  void addProducts(){
		System.out.println("\n");
		System.out.println("1 - Vegetable");
		System.out.println("2 - Fruit");
		System.out.println("3 - Greenery");
		
		System.out.println("Select a category to add a new product(1-3):");
		int product = sc.nextInt();
		
		System.out.println("Enter Product name : ");
		String pname = sc.next();
		System.out.println("Enter Storage Quantity : ");
		String quantity = sc.next();
		
		switch(product) {
		case 1:
			withVegetable.put(pname,quantity);
			System.out.println("Successfully added the vegetable product!!!\n");
			break;
		
	    case 2:
		    withFruit.put(pname,quantity);
		    System.out.println("Successfully added the fruit product!!!\n");
		    break;
		    
	    case 3:
		    withGreenery.put(pname,quantity);
		    System.out.println("Successfully added the greenery product!!!\n");
		    break;
		    
	    default:
			System.out.println("Invalid menu selection");
		}
	} 
		
		
		
	@Override
	public void displayProductList() {
		System.out.println("\n");
		System.out.println("1 - Vegetable");
		System.out.println("2 - Fruit");
		System.out.println("3 - Greenery");
		
		System.out.println("Select a category to display the products(1-3):");
		int product1 = sc.nextInt();
		switch(product1) {
		case 1:
			System.out.println("*******Stored products for Vegetable Category******* "+"\n");
			System.out.println("Product Name"+"\t" +"Storage Quantity"+"\t" +"\n");
			for(Map.Entry<String, String> vege : withVegetable.entrySet()) {
				System.out.println("  "+vege.getKey()+ "        "+vege.getValue());
			}
			break;
			
		case 2:
			System.out.println("*******Stored products for Fruit Category******* "+"\n");
			System.out.println("Product Name"+"\t" +"Storage Quantity"+"\t" +"\n");
			for(Map.Entry<String, String> fruit : withFruit.entrySet()) {
				System.out.println("  "+fruit.getKey()+ "         "+fruit.getValue());
			}
			break;
			
		case 3:
			System.out.println("*******Stored products for Greenery Category******* "+"\n");
			System.out.println("Product Name"+"\t" +"Storage Quantity"+"\t" +"\n");
			for(Map.Entry<String, String> greenery : withGreenery.entrySet()) {
				System.out.println("  "+greenery.getKey()+"        "+ greenery.getValue());
			}
			break;
			
		default:
			System.out.println("Invalid Menu Selection.");
		}	
		
	}
	
	@Override
	public void updateproductQuantity() {
		System.out.println("\n");
		System.out.println("1 - Vegetable");
		System.out.println("2 - Fruit");
		System.out.println("3 - Greenery");
		
		System.out.println("Select a category to update a product(1-3):");
		int product2 = sc.nextInt();
		
		System.out.println("Enter Product name : ");//enter the name of the product to be updated
		String pname = sc.next();
			
		switch(product2) {
		case 1:
			if(withVegetable.containsKey(pname)) {
				System.out.println("Product Name"+"\t" +"Storage Quantity(current)"+"\t" +"\n");
				for(Map.Entry<String, String> vege : withVegetable.entrySet()) {
					if(vege.getKey().equals(pname)) {
					System.out.println("  "+vege.getKey()+ "        "+vege.getValue());//display the current storage quantity of the entered product name before updating
					}
				}
				System.out.println("Enter new Storage Quantity : ");
				newquantity = sc.next();
				withVegetable.put(pname,newquantity);
				System.out.println("Successfully updated the storage quantity of vegetable product!!!\n");
			}
			else {
			
			System.out.println("Product  is not available in the list\n");
			}
			break;
		
	    case 2:
	    	if(withFruit.containsKey(pname)) {
				System.out.println("Product Name"+"\t" +"Quantity"+"\t" +"\n");
				for(Map.Entry<String, String> fruit : withFruit.entrySet()) {
					if(fruit.getKey().equals(pname)) {
					System.out.println("  "+fruit.getKey()+ "        "+fruit.getValue());
					}
				}
				System.out.println("Enter new Storage Quantity : ");
				newquantity = sc.next();
			    withFruit.put(pname,newquantity);
			    System.out.println("Successfully updated the storage quantity of  fruit product!!!\n");
			}
	    	else {
	    	
		    System.out.println("Product  is not available in the list\n");
	    	}
		    break;
		    
	    case 3:
	    	if(withGreenery.containsKey(pname)) {
				System.out.println("Product Name"+"\t" +"Quantity"+"\t" +"\n");
				for(Map.Entry<String, String> greenery : withGreenery.entrySet()) {
					if(greenery.getKey().equals(pname)) {
					System.out.println("  "+greenery.getKey()+ "        "+greenery.getValue());
					}
				}
				System.out.println("Enter new Storage Quantity : ");
				newquantity = sc.next();
			    withGreenery.put(pname,newquantity);
			    System.out.println("Successfully updated the storage quantity of greenery product!!!\n");
			}
	    	else {
	
		    System.out.println("Product  is not available in the list\n");
	    	}
		    break;
		    
	    default:
			System.out.println("Invalid menu selection");
		}
				
		
	}
	
	
	@Override
	public  void removeProducts(){
		System.out.println("\n");
		System.out.println("1 - Vegetable");
		System.out.println("2 - Fruit");
		System.out.println("3 - Greenery");
		
		System.out.println("Select a category to remove a product(1-3):");
		int product3 = sc.nextInt();
		
		System.out.println("Enter Product name : ");
		String pname = sc.next();
		
		
		
		switch(product3) {
		case 1:
			if(withVegetable.containsKey(pname)) {
				
				Iterator<String> iterator = withVegetable.keySet().iterator();
				
				while(iterator.hasNext()){
					String vegetable = iterator.next();
					if(vegetable.contains(pname)){
				        iterator.remove();
				      }
				}
			
				System.out.println("Successfully deleted the vegetable product!!!\n");
			}
			else {
			
			System.out.println("Product  is not available in the list\n");
			}
			break;
		
	    case 2:
	    	if(withFruit.containsKey(pname)) {
	    		Iterator<String> iterator = withFruit.keySet().iterator();
				
	    		while(iterator.hasNext()){
					String fruit = iterator.next();
					if(fruit.contains(pname)){
				        iterator.remove();
				      }
				}
			
			    System.out.println("Successfully deleted the  fruit product!!!\n");
			}
	    	else {
	    	
		    System.out.println("Product  is not available in the list\n");
	    	}
		    break;
		    
	    case 3:
	    	if(withGreenery.containsKey(pname)) {
                Iterator<String> iterator = withGreenery.keySet().iterator();
				
	    		while(iterator.hasNext()){
					String greenery = iterator.next();
					if(greenery.contains(pname)){
				        iterator.remove();
				      }
				}
				
			    System.out.println("Successfully deleted the greenery product!!!\n");
			}
	    	else {
	
		    System.out.println("Product  is not available in the list\n");
	    	}
		    break;
		    
	    default:
			System.out.println("Invalid menu selection");
		}
		
			
		
	}
	
	public void displayRestoreProducts() {
		System.out.println("\n");
		System.out.println("1 - Vegetable");
		System.out.println("2 - Fruit");
		System.out.println("3 - Greenery");
		
		System.out.println("Select a category to display the products to be restored(1-3):");
		int restore = sc.nextInt();
		switch(restore) {
		
		case 1:
			System.out.println("*******Products to be restored for Vegetable Category******* "+"\n");
			System.out.println("Product Name"+"\t" +"Storage Quantity"+"\t" +"\n");
			for(Map.Entry<String, String> vege : withVegetable.entrySet()) {
				if(vege.getValue().endsWith("Kg")== false) { //checks whether the storage quantity of stored products is in 'g',so that it is needed to be restored.
				System.out.println("  "+vege.getKey()+ "        "+vege.getValue());
				}
			}
			
			break;
		case 2:
			System.out.println("*******Products to be restored for Fruit Category******* "+"\n");
			System.out.println("Product Name"+"\t" +"Storage Quantity"+"\t" +"\n");
			for(Map.Entry<String, String> fruit : withFruit.entrySet()) {
				if(fruit.getValue().endsWith("Kg")== false) {
				System.out.println("  "+fruit.getKey()+ "        "+fruit.getValue());
				}
			}
			
			break;
		case 3:
			System.out.println("*******Products to be restored for Greenery Category******* "+"\n");
			System.out.println("Product Name"+"\t" +"Storage Quantity"+"\t" +"\n");
			for(Map.Entry<String, String> greenery : withGreenery.entrySet()) {
				if(greenery.getValue().endsWith("Kg")== false) {
				System.out.println("  "+greenery.getKey()+ "        "+greenery.getValue());
				}
			}
			
			break;
		default:
			System.out.println("Invalid Menu Selection.");
		
		
		}
		
		
	}
	
	
		
	}
	
	


