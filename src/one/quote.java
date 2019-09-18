package one;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

public class quote {

	
	public static void main(String[] args) throws JSONException {
		
		Client client = ClientBuilder.newClient();

		String url="https://api.kanye.rest/";
		
		WebTarget target = client.target(url);

		String output = target.request(MediaType.APPLICATION_JSON).get(String.class);
		//System.out.println(output);
		
		JSONObject jsonObject =new JSONObject(output);
		
		Object Quote=jsonObject.get("quote");
		System.out.println("Todays Quote is :" +" "+Quote);
		
	}
}
