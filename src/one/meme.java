package one;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class meme {
	
	

public static void main(String[] args) throws JSONException {
	

	Client client = ClientBuilder.newClient();

	String url="https://api.imgflip.com/get_memes";
	
	WebTarget target = client.target(url);

	String output = target.request(MediaType.APPLICATION_JSON).get(String.class);
	//System.out.println(output);
	
	JSONObject jsonObject =new JSONObject(output);
	
	
	JSONObject jsonObject2=jsonObject.getJSONObject("data");
	//System.out.println(jsonObject2);
	
	JSONArray jsonArray=jsonObject2.getJSONArray("memes");
	//System.out.println(jsonArray);
	
	JSONObject data=(JSONObject) jsonArray.get(3);
	System.out.println(data);
	
	Object obj=data.get("url");
	System.out.println(obj);
	
	Object ID=data.get("id");
	System.out.println(ID);
	
	Object NAME=data.get("name");
	System.out.println(NAME);
	
	
	

	
	
	
	
}
}