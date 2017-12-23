package ie.gmit.sw;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;

public class DictionaryClient implements Runnable{
	
	private Registry registry;
	private DictionaryService dictionaryService;
	
	public DictionaryClient() throws RemoteException, NotBoundException{
		registry = LocateRegistry.getRegistry("localhost", 1099);
	    dictionaryService = (DictionaryService) registry.lookup("DictonaryService");
	}
	
	@Override
	public void run() {
		
		while(true){
			// get you need lookup KEY from queue
			Map<String, String> map = QueryQueue.getRequestQueue();
			
			if(map != null){ 
				try {
					//lookup result and add inqueue
					String result = null;
					result = dictionaryService.query(map.get("key"));
					map.put("key", result);
					System.out.println(result);
					QueryQueue.addOutQueue(map);
					
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}else{ //when the queue is empty then sleep 5seconds
				System.out.println("sleep...");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
