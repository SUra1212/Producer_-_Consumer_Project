package consumerretailer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import deliveryservicepublisher.DeliveryService;

public class Activator implements BundleActivator {

	ServiceReference deliveryServiceReference;

	
	//start retailer consumer
	public void start(BundleContext context) throws Exception {
		System.out.println("~~~~~~~~~~~~Retailer consumer started~~~~~~~~~~~~~~~");
		deliveryServiceReference = context.getServiceReference(DeliveryService.class.getName());
		DeliveryService deliveryService =  (DeliveryService)context.getService(deliveryServiceReference);
		
		//to read the input values
		Scanner sc = new Scanner(System.in);
		while(true) {
			//display the list which retailer can select the option
	        System.out.println("1. Get items");
	        System.out.println("2.View list");
	        System.out.println("3.Update item list");
	        System.out.println("4.Delete item in a list");
	        System.out.println("5.Select the pay method");
	        System.out.println("6.Exit");
	        //to select the option and read 
	        System.out.println("Select option:");
	        String opt = sc.nextLine();
	        //do below tasks according to the option that retailer selected
	        switch(opt) {
	        case "1":
	        	deliveryService.getItems();
	        	break;
	        case "2":
	        	deliveryService.displaylist();
	        	break;
	        case "3":
	        	deliveryService.updatelist();
	        	break;
	        case "4":
	        	deliveryService.deletelistitem();
	        	break;
	        case "5":
	        	deliveryService.Payment();
	        	break;
	        case "6":
	        	System.out.println("Exit the page");
	        	return;
	        default:
	        	System.out.println("Invalid option.Please select correct option!!\n");
	        }
		}
		
	}

	//stop the retailer consumer
	public void stop(BundleContext context) throws Exception {
		System.out.println("~~~~~~~~~~~~Retailer consumer stopped~~~~~~~~~~~~~~~");
		context.ungetService(deliveryServiceReference);
	}
		
	   

}
