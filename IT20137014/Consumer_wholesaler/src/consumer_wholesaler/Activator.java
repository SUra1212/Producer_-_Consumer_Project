package consumer_wholesaler;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import deliveryservicepublisher.DeliveryService;

public class Activator implements BundleActivator {

	ServiceReference deliveryServiceReference;

	//start the wholesaler consumer
	public void start(BundleContext context) throws Exception {
		System.out.println("~~~~~~~~~~~~WholeSaler consumer started~~~~~~~~~~~~~~~");
		System.out.println();
		deliveryServiceReference = context.getServiceReference(DeliveryService.class
				         .getName());
		DeliveryService deliveryService =  (DeliveryService)context
				         .getService(deliveryServiceReference);
		
		//to read the input values
        Scanner sc = new Scanner(System.in);
		
		
		//start wholesaler process
		
		System.out.println("---------------Welcome All wholesale buyers-----------------------------");
		while(true) {
			//wholesaler can select the option
		String option;
		System.out.println("Select the option");
		System.out.println("1.Bill of Order items with sub total");
		System.out.println("2.Pay methods");
		System.out.println("3.Exit");
	
		//enter option with adding option number and read it
		System.out.println("Enter the option:");
		option = sc.nextLine();
		
		//do tasks according to the option number
		switch(option) {
        case "1":
        	deliveryService.displayOrderDetails();
        	break;
        case "2":
        	deliveryService.Payment();
        	break;
        case "3":
        	System.out.println("Exit from the system");
        	return;
        default:
        	System.out.println("Invalid");
        }
	
		}
	
	
		
	}

	//stop wholesaler consumer
	public void stop(BundleContext context) throws Exception {
		System.out.println("~~~~~~~~~~~~WholeSaler consumer stopped~~~~~~~~~~~~~~~");
		context.ungetService(deliveryServiceReference);
	}

}
