package com.zup.app.backend;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zup.app.backend.model.Products;

@Path("/products")
public class ProductsService {
	
	@GET
	  @Path("/all")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getAllProducts() {
		Products p = new Products();
		
	    String result = "---Products List---\n";
	    for(String product : p.getAllProducts()){
	    	result += product;
	    	result += "\n";
	    }
	    p.closeConnection();
				
	    return result;    
	  }

}
