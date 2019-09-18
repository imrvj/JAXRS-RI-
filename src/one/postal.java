package one;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class postal {

	public static void main(String[] args) throws JSONException {

		Scanner s = new Scanner(System.in);

		String pincode;

		System.out.println("Enter Pincode");
		pincode = s.nextLine();

		Client client = ClientBuilder.newClient();

		String url = "http://postalpincode.in/api/pincode/" + pincode;

		WebTarget target = client.target(url);

		String output = target.request(MediaType.APPLICATION_JSON).get(String.class);

		JSONObject jsonObject = new JSONObject(output);

		Object status = jsonObject.get("Status");

		System.out.println(status);

		JSONArray POSTOFFICE = jsonObject.getJSONArray("PostOffice");

		JSONObject data = POSTOFFICE.getJSONObject(0);

		Object State = data.get("State");
		System.out.println("State is : " + " " + State);

		Object Dist = data.get("District");
		System.out.println("District is : " + " " + Dist);

		Object Reg = data.get("Region");
		System.out.println("Region is : " + " " + Reg);

		Object con = data.get("Country");
		System.out.println("Country is : " + " " + con);

	}
}
