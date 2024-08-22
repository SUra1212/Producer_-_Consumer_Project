package farmerconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import storemanagerproducer.StoreManagerProducerInf;

public class FarmerConsumerActivator implements BundleActivator {

	private ServiceReference  storemanagerproducerref;

	public void start(BundleContext context) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Farmer consumer started.");
		storemanagerproducerref = context.getServiceReference(StoreManagerProducerInf.class.getName());
		@SuppressWarnings("unchecked")
		StoreManagerProducerInf storage = (StoreManagerProducerInf) context.getService(storemanagerproducerref);
		
		while(true) {
			System.out.println("\n ========= ~ Welcome to Fertilizer and Seed Management ~ =========");
	        System.out.println("Press 1 to add new product details");
	        System.out.println("Press 2 to view all product details");
	        System.out.println("Press 3 to search product details");
	        System.out.println("Press 4 to delete product details");
	        System.out.println("Press 5 to update product details");
	        System.out.println("Press 6 to Exit \n");
	        System.out.println("Enter a Number :");
	        int selection = sc.nextInt();
	        
	        if(selection ==6) break;
	        
	        switch(selection) {
	        case 1:
	        	storage.addProducts();
	        	break;
	        case 2:
	        	storage.displayProductList();
	        	break;
	        case 3:
	        	storage.Search();
	        	break;
	        case 4:
	        	storage.Delete();
	        	break;
	        case 5:
	        	storage.Update();
	        	break;
	        default:
	        	System.out.println("Invalid number inserted!");
	        }

	        	
		}
		
		

	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stock Manager consumer stopped.");
		context.ungetService(storemanagerproducerref);
	}
}
