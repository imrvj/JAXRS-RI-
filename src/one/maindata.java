package one;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

public class maindata {

	
	public static void main(String[] args) throws JSONException {
		
		Client client = ClientBuilder.newClient();

		String url="https://api.openweathermap.org/data/2.5/weather?q=Delhi&APPID=6fe84926b061ee8a1bdcb83831837575";
		
		WebTarget target = client.target(url);

		String output = target.request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(output);

		JSONObject jsonobject = new JSONObject(output);
		JSONObject Main = jsonobject.getJSONObject("main");
		//JSONObject visible=jsonobject.getJSONObject("visibility");
		JSONObject Wind=jsonobject.getJSONObject("wind");
		
		if(Main!=null)
		{
			Object temp=Main.get("temp");
			System.out.println("temp is "+temp);
			
			Object pressure = null;
            Object humidity = null;
           // Object visibility=null;
            Object speed=null;
            
            pressure=Main.get("pressure");
            humidity=Main.get("humidity");
           // visibility=visible.get("visibility");
            
            speed=Wind.get("speed");
            System.out.println("temp is "+pressure);
            System.out.println("temp is "+humidity);
            //System.out.println("visiblity is "+visibility);
            System.out.println("wind is "+speed);
		}
		
		
	}
}
