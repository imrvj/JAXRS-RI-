package one;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class catstatus {

	public static void main(String[] args) {
		
		
		
		Client client = ClientBuilder.newClient();

		String url="https://http.cat/";
		
		WebTarget target = client.target(url);

		String output = target.request(MediaType.APPLICATION_XHTML_XML).get(String.class);
		System.out.println(output);
	}
}
