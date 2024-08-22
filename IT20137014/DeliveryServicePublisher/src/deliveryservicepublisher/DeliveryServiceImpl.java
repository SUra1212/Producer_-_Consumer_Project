package deliveryservicepublisher;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;



public class DeliveryServiceImpl implements DeliveryService{

	//display order list when calling the order id from the wholesaler consumer
	@Override
	public  void displayOrderDetails() {
		 
		
		Scanner sc = new Scanner(System.in);
	    System.out.println("------------Delivery Details----------------");
	    //to enter the order id
	    System.out.println("Enter Order ID to display bill:");
	    //read order id
		String orderID = sc.nextLine();
		

		//select order id and find it is in the list or not if it is in the list it display below order list
		switch(orderID) {
		case "AFM_ORD_ID010":
			System.out.println("----------Ordered List----------");
			System.out.println("Item           Qty                Value(Rs)");
			System.out.println("green chilli   10kg                5000");
			System.out.println("brinjal        25kg                5000");
			System.out.println("tomato         20kg                4000");
			System.out.println("pumpkin        50kg               10000");
			System.out.println("Sub total:                        24000");
			break;
		case "AFM_ORD_ID002":
			System.out.println("----------Ordered List----------");
			System.out.println("Item           Qty                Value(Rs)");
			System.out.println("manioc         20kg                2000");
			System.out.println("potato         30kg                4500");
			System.out.println("brinjal        20kg                4000");
			System.out.println("pumpkin        50kg               10000");
			System.out.println("Sub total:                        20500");
			break;
		
		case "AFM_ORD_ID001":
			System.out.println("----------Ordered List----------");
			System.out.println("Item           Qty                Value(Rs)");
			System.out.println("mango          50kg               10000");
			System.out.println("beans          20kg                3200");
			System.out.println("pumpkin        50kg               10000");
			System.out.println("manioc         10kg                1000");
			System.out.println("Sub total:                        24200");
			break;
		case "AFM_ORD_ID003":
			System.out.println("----------Ordered List----------");
			System.out.println("Item           Qty                Value(Rs)");
			System.out.println("red chilli     10kg               10000");
			System.out.println("beans          20kg                3200");
			System.out.println("tomato         10kg                2000");
			System.out.println("lemon          10kg                1000");
			System.out.println("Sub total:                        16200");
		    break;
		default: 
			//invalid order id and display error message
			System.out.println("Invalid order ID. Please check it again..\n");
			orderID = sc.nextLine();
		}
		
		
	}
	

	HashMap<String, String> payment = new HashMap<String, String>();
	@Override
	public void Payment() {
		Scanner sc1 = new Scanner(System.in);
	
		System.out.println("Select the Pay method");
		System.out.println("1.Cash");
		System.out.println("2.Card");
		System.out.println("3.Cheque");
	
		//to enter the order id
	    System.out.println("Enter Order ID to display bill:");
	    //read order id
		String orderID = sc1.nextLine();
		//to enter payment method
		System.out.println("Enter pay method:");
		//read the payment method which added
		String payMethod = sc1.next();
		//put them to the hashmap
		payment.put(orderID,payMethod);
		
		//if selected pay method are as below numbers, do the tasks according to this switch
		switch(payMethod) {
        case "1":
        	System.out.println("You select pay method as" + " ' " + payMethod + " '.\n" + "Confirmed your cash payment of your order ID: " + orderID + ". Thank you.\n");
        	break;
        case "2":
        	System.out.println("You select pay method as" + " ' " + payMethod + " '.\n" + "Confirmed your cash payment of your order ID: " + orderID + ". Thank you.\n");
        	break;
        case "3":
        	System.out.println("You select pay method as" + " ' " + payMethod + " '.\n" + "Confirmed your cash payment of your order ID: " + orderID + ". Thank you.\n");
        	break;
        default:
        	System.out.println("Invalid pay method...Please re-enter your pay method\n");
        	
        }
	  }
	

	//hashmap for list the item name(key) and quantity(value)
	HashMap<String, Integer> ItemSelectedByRetailer = new HashMap<String, Integer>();
	@Override
	public void getItems() {
		
		Scanner sc2 = new Scanner(System.in);
		//Enter item name
		System.out.println("Enter Item name you wanted : ");
		String itemname = sc2.nextLine();
		//enter quantity of the item
		System.out.println("Enter Quantity that you wanted(kg) : ");
		int qty = sc2.nextInt();
		System.out.println();
		//put item name and the quantity to the hashmap
		ItemSelectedByRetailer.put(itemname,qty);
		//print the value that added to the hashmap
		System.out.println("You added" +" " + itemname + "  "+ qty + "kg to your list successfully" );
		System.out.println();
	
	}

	@Override
	public void displaylist() {
		System.out.println("~~~~~~~~~~~~~~~~Item List~~~~~~~~~~~~~~~~~~~~~`");
		//to list down the values inside the hashmap and display the list
		 for (Map.Entry<String, Integer> ItmSelected : ItemSelectedByRetailer.entrySet()) {
	           System.out.println("Item name: " + ItmSelected.getKey()
	                   + "   |   "
	                   + " Quantity: " + ItmSelected.getValue() + "kg");
	       }
		 System.out.println();
		
        }

	@Override
	public void updatelist() {
		Scanner sc3 = new Scanner(System.in);
		//enter the item name which wanted to update its quantity
		System.out.println("Enter item name that you wanted to update the quantity:");
		String itemname = sc3.nextLine();
		//to add new quantity
        System.out.println("Enter Quantity that you wanted(kg) : ");
		int qty = sc3.nextInt();
		//previous quantity is replaced with new added quantity
		int prevqty = ItemSelectedByRetailer.replace(itemname,qty);
		//print the value with the newly added quantity with related item name
		System.out.println("Your updated list value: " + itemname + "   " + qty + "kg");
		System.out.println();
		
		
	}

	@Override
	public void deletelistitem() {
		Scanner sc4 = new Scanner(System.in);
		//enter item name which wanted to delete in the item list 
		System.out.println("Enter item name that you wanted to delete:");
		String itemname = sc4.nextLine();
		//ewmove item from the hashmap
		ItemSelectedByRetailer.remove(itemname);
		//print the deleted item name
		System.out.println("Your deleted item: " + itemname);
		System.out.println();
		
	}
	 
		
	

	
	
	
	
	

}
