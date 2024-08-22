package storekeeperproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class StoreKeeperActivator implements BundleActivator {

	ServiceRegistration stServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("StoreKeeper Producer Started.");
	    StoreKeeperInterface storage = new StoreKeeperImpl();
		stServiceRegistration = context.registerService(
				StoreKeeperInterface.class.getName(), storage, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("StoreKeeper Producer Stopped.");
		stServiceRegistration.unregister();
	}

}
