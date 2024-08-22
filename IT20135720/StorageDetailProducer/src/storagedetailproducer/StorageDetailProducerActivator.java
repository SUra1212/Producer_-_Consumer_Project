package storagedetailproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class StorageDetailProducerActivator implements BundleActivator {

	
	ServiceRegistration serviceRegisterer;

	

	public void start(BundleContext context) throws Exception {//life-cycle method:start
		System.out.println("Storage detail producer started.");
		StorageDetailProducerInf storage = new StorageDetailProducerImpl();
		serviceRegisterer = context.registerService(
				StorageDetailProducerInf.class.getName(), storage, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {//life-cycle method:stop
		System.out.println("Storage detail producer stopped.");
		try {
		serviceRegisterer.unregister();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
