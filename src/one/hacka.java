package one;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hacka {
	
	public static void main(String[] args) throws JSONException {
		
		Client client = ClientBuilder.newClient();

		String url="http://www.hackathonwatch.com/api//hackathons/coming.json";
		WebTarget target = client.target(url);

		String output = target.request(MediaType.APPLICATION_JSON).get(String.class);
		//System.out.println(output);
		
		JSONArray jsonArray=new JSONArray(output);
		JSONObject obj=(JSONObject) jsonArray.get(2);
		//System.out.println(obj);
		
		Object id=obj.get("id");
		Object des=obj.get("description");
		
		Object name=obj.get("name");
		
		System.out.println("Name is "+name);
		System.out.println("Description"+des);
		System.out.println("ID"+id);
		

		
		
	}

}
