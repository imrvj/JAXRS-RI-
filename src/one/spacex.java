package one;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class spacex {

	
	public static void main(String[] args) throws JSONException {
		
		Client client = ClientBuilder.newClient();

		String url="https://api.spacexdata.com/v3/launches/latest";
		
		WebTarget target = client.target(url);

		String output = target.request(MediaType.APPLICATION_JSON).get(String.class);
		//System.out.println(output);
		
		JSONObject jsonObject=new JSONObject(output);
		JSONObject jsonObject2=jsonObject.getJSONObject("rocket");
		//System.out.println(jsonObject2);
		JSONObject jsonObject3=jsonObject2.getJSONObject("first_stage");
		//System.out.println(jsonObject3);
		
		JSONArray jsonArray=jsonObject3.getJSONArray("cores");
		//System.out.println(jsonArray);
		
		JSONObject jsonObject4=jsonArray.getJSONObject(0);
		Object obj=jsonObject4.get("legs");
		System.out.println("Legs is :"+obj);
		
		
		
		
		
		
	}
}
