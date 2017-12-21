package ie.gmit.sw;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryServiceImpl implements DictionaryService{
	
	private Map<String, String> dictonaryMap = null;
	//create dictionary datebase
	public DictionaryServiceImpl(){
		dictonaryMap = new HashMap();
		dictonaryMap.put("appetizer", "a small portion of a food or drink served before or at the beginning of a meal to stimulate the appetite");
		dictonaryMap.put("apperception", "the act or process of apperceiving.");
		dictonaryMap.put("RMI", "Remote method invocation");
		dictonaryMap.put("appendicle","a small appendage");
		dictonaryMap.put("apperceive","have conscious perception of comprehend");
		dictonaryMap.put("appestat","a presumed region in the human brain");
		dictonaryMap.put("bargain","an agreement between parties");
		dictonaryMap.put("bunch","a cluster held together");
		dictonaryMap.put("blood","the red fluid that flows through the heart throughout the body");
		dictonaryMap.put("board","material made in large sheets, as plasterboard");
		dictonaryMap.put("catch","to seize or capture");
		dictonaryMap.put("convey","to take from one place to anothertransport");
		dictonaryMap.put("clumsy","awkwardly or poorly done");
		dictonaryMap.put("custody","guardianship");
		dictonaryMap.put("drifting","a driving movement, as of a current of water");
		dictonaryMap.put("dazzling","to blind temporarily with bright light");
		dictonaryMap.put("ecstasy","extreme joyfulness or happiness");
		dictonaryMap.put("elaborate","worked out in great detail");
		dictonaryMap.put("eliminate","to get rid of");
		dictonaryMap.put("fabrication","the making up or inventing of false stories");
		dictonaryMap.put("fag","to fray or unlay the end of ");
		dictonaryMap.put("faint","lacking brightness");
		dictonaryMap.put("gadget","a small mechanical apparatus or electronic device");
		dictonaryMap.put("gaff","an iron hook with a handle for pulling in or moving large fish");
		dictonaryMap.put("gang","a group or band");
		dictonaryMap.put("garret","an attic, usually a small, wretched one");
		dictonaryMap.put("halt","a temporary or permanent stop");
		dictonaryMap.put("hardcore","those whose condition seems to be without hope of remedy or change");
		dictonaryMap.put("harsh","not gentle or pleasant");
		dictonaryMap.put("ignite","to set on fire");
		dictonaryMap.put("illusion","something that deceives one by producing a false impression of what is real");
		dictonaryMap.put("immaculate","free from stain");
		dictonaryMap.put("immerse","to plunge into or place under a liquid");
		dictonaryMap.put("jeopardized","cause danger, risk, or peril to");
		dictonaryMap.put("kiln","a furnace or oven for burning, baking, or drying something");
		dictonaryMap.put("laguna","a bay, inlet, or other narrow or shallow body of water");
		dictonaryMap.put("macro","very large in scale, scope, or capability");
		dictonaryMap.put("magnificent","splendid or impressive in appearance");
		dictonaryMap.put("nasty","offensive to taste, smell, or the senses in general");
		dictonaryMap.put("obsessed","having an obsession ");
		dictonaryMap.put("pageant","a parade in which the participants wear fancy, decorative costumes");
		dictonaryMap.put("quail","a small, plump bird of the pheasant family");
		dictonaryMap.put("racial","relating to, or characteristic of one race or the races of humankind");
		dictonaryMap.put("sack","a large bag of strong, rough, woven material, as for potatoes");
		dictonaryMap.put("taoist","a popular Chinese religion, originating in the doctrines of Lao-tzu but later highly eclectic in nature and characterized by a pantheon of many gods and by the practice of alchemy, divination, and magic");
		dictonaryMap.put("undergo","to be put through");
		dictonaryMap.put("vague","not clearly stated or expressed");
		dictonaryMap.put("wallop","to defeat thoroughly, as in a game");
		dictonaryMap.put("yield","to give up, as to superior power or authority");
		dictonaryMap.put("zoom","to move quickly or suddenly with a loud humming or buzzing sound");
	}

	@Override
	public String query(String key) throws RemoteException{
		String result = "String not found!";
		if(dictonaryMap.containsKey(key)){
			result = dictonaryMap.get(key);
		}
		return result;
	}
	
}
