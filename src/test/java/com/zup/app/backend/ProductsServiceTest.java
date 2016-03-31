package com.zup.app.backend;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;


public class ProductsServiceTest{

	private HttpServer server;
	private WebTarget target;

	@Before
	public void setUp() throws Exception {
		// start the server
		server = Main.startServer();
		// create the client
		Client c = ClientBuilder.newClient();

		// uncomment the following line if you want to enable
		// support for JSON in the client (you also have to uncomment
		// dependency on jersey-media-json module in pom.xml and Main.startServer())
		// --
		c.register(JacksonJaxbJsonProvider.class);

		target = c.target(Main.BASE_URI);
	}

	@After
	public void tearDown() throws Exception {
		server.shutdownNow();;
	}

	@Test
	public void testGetAllProducts() {
		final Response response = target.path("/products/all")
				.request(MediaType.APPLICATION_JSON)
				.get();

		assertEquals(200, response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON, response.getMediaType());
		//System.out.println("================");
		//System.out.println(response.readEntity(String.class));
	}
	
	@Test
	public void testGetProduct() {
		final Response response = target.path("/products/47056")
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		System.out.println("================");
		System.out.println(response.readEntity(String.class));
		
		assertEquals(200, response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON, response.getMediaType());
		
	}

}
