package ie.gmit.sw;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
	public static void main(String[] args) throws Exception{
		DictionaryServiceImpl dictonaryServiceImpl = new DictionaryServiceImpl();
		UnicastRemoteObject.exportObject(dictonaryServiceImpl,2016);
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind("DictonaryService", dictonaryServiceImpl);
		System.out.println("service start success");
	}
}
