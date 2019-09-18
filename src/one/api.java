package one;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;

public class api {
	@POST
	public static void main(String[] args) throws JSONException {

		// make connection
		Client client = ClientBuilder.newClient();

		String url = "http://ec2-34-211-69-40.us-west-2.compute.amazonaws.com/api/v1/get-product";
		
		
	Builder jsonStr = client.target(url)
				.request(MediaType.APPLICATION_JSON)

				.header("store_id", "4")
				.header("token",
						"fvElyuH3-RM:APA91bEGHqLNXqtxzFA8JzxOJ2EQjnZG9fR3sR_vh49Zw7Kw0NO6Lq2lcimRgS5rYCiMS9ic0vRmId1fruMKlacOpd6Ax0_pgv_rs6XT6L8YvjbAYwguxGhgs_-b6FmvACSfrLFyV5_j")
				.header("barcode", "420479230620");
	
	Response res = jsonStr.get();


		System.out.println(res);

	}

}
