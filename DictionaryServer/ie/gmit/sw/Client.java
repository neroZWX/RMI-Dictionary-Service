package ie.gmit.sw;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) throws Exception {
		 Registry registry = LocateRegistry.getRegistry("localhost", 1099);
		 DictionaryService dictonaryService = (DictionaryService) registry.lookup("DictonaryService");
		 System.out.println(dictonaryService.query("hello"));
	}
}
