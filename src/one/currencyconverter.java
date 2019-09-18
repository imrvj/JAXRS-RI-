package one;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

public class currencyconverter {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws JSONException {
		
		Double a,b,c;
		Object india;
		Scanner s=new Scanner(System.in);
		
		Client client = ClientBuilder.newClient();

		String url="https://api.exchangerate-api.com/v4/latest/USD";
		
		WebTarget target = client.target(url);

		String output = target.request(MediaType.APPLICATION_JSON).get(String.class);
		//System.out.println(output);
		
		JSONObject jsonObject =new JSONObject(output);
		
		JSONObject Rates=jsonObject.getJSONObject("rates");
		//System.out.println(Rates);
		
		System.out.println("Enter Dollars you want to convert to Indina Rupees");
	      a=s.nextDouble();
	      
		 india=Rates.get("INR");
		//System.out.println(india);
		
		b = ((Number) india).doubleValue();
		 
		c=a*b;
		
		System.out.println("output is"+c);
		
	}

}
