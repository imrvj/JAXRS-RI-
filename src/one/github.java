package one;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

public class github {

	
	public static void main(String[] args) throws JSONException {
		
		Client client = ClientBuilder.newClient();

		String url="https://api.github.com/";
		
		WebTarget target = client.target(url);

		String output = target.request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(output);
		
		JSONObject jsonObject=new JSONObject(output);
		Object obj=jsonObject.get("current_user_url");
		System.out.println(obj);
		
	}
}
