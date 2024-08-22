package stockmanagerconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import storagedetailproducer.StorageDetailProducerInf;

public class StockManagerConsumerActivator implements BundleActivator {

	
	private ServiceReference  storagedetailproducerref;

	
	public void start(BundleContext context) throws Exception { //life-cyle method: start
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Stock Manager consumer started.");
		storagedetailproducerref = context.getServiceReference(StorageDetailProducerInf.class.getName());
		@SuppressWarnings("unchecked")
		StorageDetailProducerInf storage = (StorageDetailProducerInf) context.getService(storagedetailproducerref);

		
		
        while(true) {
			System.out.println("================Welcome to Product Storage Management ================= ");
	        System.out.println("1. Add new products");
	        System.out.println("2. View product storage details");
	        System.out.println("3. Update product storage details");
	        System.out.println("4. Delete a product storage record");
	        System.out.println("5. View products to be restored");
	        System.out.println("6. Exit\n");
	        System.out.println("Please select an option(1-6):");
	        
	        int selection = sc.nextInt();
	        
	        if(selection == 6) break;
			
	        switch(selection) {
	        case 1:
	        	storage.addProducts(); //allows stock manager to add new products
	        	break;
	        case 2:
	        	storage.displayProductList();  //allows stock manager to view the  stored products
	        	break;
	        case 3:
	        	storage.updateproductQuantity(); //allows the stock manager to update the storage quantity of products upon selling
	        	break;
	        case 4:
	        	storage.removeProducts();//allows the stock manager to remove any record of stored products
	        	break;
	        case 5:
	        	storage.displayRestoreProducts();//allows the stock manager to view the products that need to be restored
	        	break;
	       
	        default:
	        	System.out.println("Invalid input,Please try again.");
	        }
		}
		
		
	}
		
    
		
		
	

	public void stop(BundleContext context) throws Exception { //life-cycle method:stop
		System.out.println("Stock Manager consumer stopped.");
		try {
		context.ungetService(storagedetailproducerref);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
