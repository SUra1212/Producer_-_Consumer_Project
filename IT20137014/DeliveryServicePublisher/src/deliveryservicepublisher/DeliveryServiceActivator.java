package deliveryservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DeliveryServiceActivator implements BundleActivator {

	
	ServiceRegistration deliveryServiceRegistration;
 
	//start of Delivery Service publisher
	public void start(BundleContext context) throws Exception {
		System.out.println("~~~~~~~~~~Agricultural Farm's Delivery service process started~~~~~~~~~~~~");
		DeliveryService deliverService = new DeliveryServiceImpl();
		deliveryServiceRegistration = context.registerService(
				DeliveryService.class.getName(), deliverService, null);

		
		
	}

	//stop delivery service publisher
	public void stop(BundleContext context) throws Exception {
		System.out.println("~~~~~~~~~~Agricultural Farm's Delivery service process stoped~~~~~~~~~~~~");
		deliveryServiceRegistration.unregister();
	}

}
