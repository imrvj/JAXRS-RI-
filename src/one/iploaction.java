package one;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

public class iploaction {
	
	public static void main(String[] args) throws Exception   {
		
		Client client = ClientBuilder.newClient();
		
		System.out.println("Enter IP Address");
		Scanner s=new Scanner(System.in);
		String a=s.nextLine();

		String url="http://ip-api.com/json/"+a;
		
		WebTarget target = client.target(url);

		String output = target.request(MediaType.APPLICATION_XHTML_XML).get(String.class);
		
		
		//System.out.println(output);
		
		JSONObject jsonObject=new JSONObject(output);
		
		
		Object isp=jsonObject.get("isp");
		if(isp!=null)
		{
			System.out.println("ISP Provider is "+isp);
		}
		else
		{
			throw new Exception("wo to nhi mila");
		}
		
		
		Object city=jsonObject.get("city");
		System.out.println("City is "+city);
		
		Object country=jsonObject.get("country");
		System.out.println("country is "+country);
		
		Object zip=jsonObject.get("zip");
		System.out.println("zipcode is "+zip);
		
	}

}
