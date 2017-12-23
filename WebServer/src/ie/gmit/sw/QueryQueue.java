package ie.gmit.sw;


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Input and output queue
 * @author ho
 *
 */
public class QueryQueue {
	
	//request queue
	private static Queue<Map> requestQueue = new LinkedList<Map>();
	//save the result queue
	private static Queue<Map> outQueue = new LinkedList<Map>();
	
	
	public static void addRequestQueue(Map map){
		requestQueue.offer(map);
	}
	public static Map getRequestQueue(){
		return requestQueue.poll();
	}
	
	public static void addOutQueue(Map map){
		outQueue.offer(map);
	}
	
	public static Map getOutQueueElement(){
		if(outQueue.size() > 0){
			return outQueue.element();
		}
		return null;
	}
	
	public static Map getOutQueuePoll(){
		return outQueue.poll();
	}
	
}
