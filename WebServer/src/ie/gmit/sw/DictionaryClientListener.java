package ie.gmit.sw;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DictionaryClientListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			//Start monitoring the queue of threads
			new Thread(new DictionaryClient()).start();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
