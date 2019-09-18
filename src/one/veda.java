package one;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class veda {

	public static void main(String[] args) throws JSONException {
		Client client = ClientBuilder.newClient();

		String url = "https://sheetlabs.com/IND/rv";

		WebTarget target = client.target(url);

		String output = target.request(MediaType.APPLICATION_XHTML_XML).get(String.class);
		
		//System.out.println(output);
		
		JSONArray jsonArray=new JSONArray(output);
		JSONObject jsonObject=jsonArray.getJSONObject(3);
		//System.out.println(jsonObject);
		
		Object obj=jsonObject.get("mandal");
		System.out.println("Mandal is "+obj);

	}
}
