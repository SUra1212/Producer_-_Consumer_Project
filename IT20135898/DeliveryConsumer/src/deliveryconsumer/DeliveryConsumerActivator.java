package deliveryconsumer;

import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import storekeeperproducer.StoreKeeperInterface;

public class DeliveryConsumerActivator implements BundleActivator {

	private ServiceReference  StoreKeeperRef;

	public void start(BundleContext context) throws Exception {
		Scanner S = new Scanner(System.in);
		System.out.println("Delivery Consumer Started.");
		StoreKeeperRef = context.getServiceReference(StoreKeeperInterface.class.getName());
		@SuppressWarnings("unchecked")
		StoreKeeperInterface storage = (StoreKeeperInterface) context.getService(StoreKeeperRef);
		
		while(true) {
	        System.out.println("1. Add New Details");
	        System.out.println("2. View All Details");
	        System.out.println("3. Search Details");
	        System.out.println("4. Delete Details");
	        System.out.println("5. Update Details");
	        System.out.println("6. Exit");
	        System.out.println("Enter a Number :");
	        int selection = S.nextInt();
	        
	        if(selection== 6) break;
	        switch(selection) {
	        case 1:
	        	storage.SellProducts();
	        	break;
	        case 2:
	        	storage.DisplayList();
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
	        	System.out.println("\n-----Invalid Input!!!-----\n");
	        }
	    	
		}
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Delivery Consumer Stopped.");
		context.ungetService(StoreKeeperRef);
	}

}

