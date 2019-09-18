package one;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

public class weather {

	public static void main(String[] args) throws JSONException {
		
		Object id,first_name,last_name;

		Client client = ClientBuilder.newClient();

		 //String
		 //url="http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=6fe84926b061ee8a1bdcb83831837575";
		String url = "https://reqres.in/api/users/2";
		
		//String url="http://ec2-34-211-69-40.us-west-2.compute.amazonaws.com/api/v1/get-product?store_id=4&token=fvElyuH3-RM:APA91bEGHqLNXqtxzFA8JzxOJ2EQjnZG9fR3sR_vh49Zw7Kw0NO6Lq2lcimRgS5rYCiMS9ic0vRmId1fruMKlacOpd6Ax0_pgv_rs6XT6L8YvjbAYwguxGhgs_-b6FmvACSfrLFyV5_j&barcode=420479230620";

		WebTarget target = client.target(url);

		String output = target.request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(output);

		JSONObject jsonobject = new JSONObject(output);
		
		
		JSONObject DATA = jsonobject.getJSONObject("data");

		if (DATA != null) {
			 id = DATA.get("id");

			System.out.println("id is " + id);

			 first_name = DATA.get("first_name");
			System.out.println("first name is " + first_name);

			 last_name = DATA.get("last_name");
			System.out.println("last name is " + last_name);

		}

	}

}
