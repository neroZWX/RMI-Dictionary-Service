package ie.gmit.sw;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * rmi interface
 * @author ho
 *
 */
public interface DictionaryService extends Remote{
	 public String query(String key) throws RemoteException;
}
