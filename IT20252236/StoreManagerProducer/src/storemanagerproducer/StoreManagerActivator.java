package storemanagerproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class StoreManagerActivator implements BundleActivator {

	ServiceRegistration serviceRegisterer;


	public void start(BundleContext context) throws Exception {
		System.out.println("Store Manager producer started.");
		StoreManagerProducerInf storage = new StoreManagerProducerImpl();
		serviceRegisterer = context.registerService(
				StoreManagerProducerInf.class.getName(), storage, null);;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Store Manager producer stopped.");
		serviceRegisterer.unregister();
	}

}
