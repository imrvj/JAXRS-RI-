package one;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

public class order {
	
	public static void main(String[] args) throws JSONException {
		
		String barcode="41053852001";
		String storeid="4";
		
		
		Client client = ClientBuilder.newClient();
		
		//String url ="https://api.openweathermap.org/data/2.5/weather?q=Delhi&APPID=6fe84926b061ee8a1bdcb83831837575";
		String url="http://ec2-34-211-69-40.us-west-2.compute.amazonaws.com/api/v1/get-product?store_id=4&barcode=41053852001";
		WebTarget target = client.target(url);
	    
		
		
		String output = target.request(MediaType.APPLICATION_JSON).get(String.class);
		//System.out.println(output);

		
		JSONObject jsonObject=new JSONObject(output);
		JSONObject DATA=jsonObject.getJSONObject("main");
		
		System.out.println(DATA);
		
		System.out.println("temp is"+DATA.get("temp"));
		
		
	}

}
