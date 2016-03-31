package com.zup.app.backend;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.zup.app.backend.model.Connector;
import com.zup.app.backend.model.Product;


public class ProductsServiceTest extends JerseyTest{
	
	//simple hello word test
    @Path("hello")
    public static class HelloResource {
        @GET
        public String getHello() {
            return "Hello World!";
        }
    }

    @Test
    public void test() {
        final String hello = target("hello").request().get(String.class);
        assertEquals("Hello World!", hello);
    }
    
    //test for add a product
	/*@Path("allproducts")
	public static class AddProductResource {
	
	    @POST
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public String doPost(Map<String, String> data) {
	        return "Hello " + data.get("name") + "!";
	    }
	
	}
	
	@Test
	public void testPost() {
	    Product product = new Product();
	    product.setName("iPhone 6");
	    product.setDescription("This is an apple phone");
	    product.setPrice(600.0f);
	    product.setCategory("Smartphones");
	
	    final String hello = target("hello")
	            .request()
	            .post(Entity.json(product.toDocument()), String.class);
	
	    assertEquals("Hello popovitsj!", hello);
	}*/
	
	//test for get all products
	@Path("allproducts")
	public static class AllProductsResource {
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Product> getAllProducts() {
			ArrayList<Product> products = new ArrayList<Product>();
			try {
				Connector.openConnection();
				products = Connector.getAllProducts();
			}catch (Exception e){
				return null;
			}finally{
				Connector.closeConnection();
			}

			return products;
		}
		
	}
	
	@Test
	public void testGetAll() {
		
		final Response response = target("allproducts")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.get();
		
		System.out.println(response.toString());
		
		assertEquals("Hello popovitsj!", response);
	}
	
	@Override
	protected Application configure() {
	    return new ResourceConfig(HelloResource.class);
	}


    
    
}
