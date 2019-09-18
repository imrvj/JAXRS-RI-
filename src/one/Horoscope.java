package one;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Horoscope {
	
	public static void main(String[] args) throws JSONException {
		
		
		Client client = ClientBuilder.newClient();

		String url="http://sandipbgt.com/theastrologer/api/horoscope/libra/today";
		
		WebTarget target = client.target(url);

		String output = target.request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(output);
		
		JSONObject jsonObject =new JSONObject(output);
		
		Object hors=jsonObject.get("horoscope");
		System.out.println(hors);
		
		JSONObject jsonObject2=jsonObject.getJSONObject("meta");
		System.out.println(jsonObject2);
		
		Object Mood=jsonObject2.get("mood");
		System.out.println(Mood);
		
				
		
		
		
	}

}
