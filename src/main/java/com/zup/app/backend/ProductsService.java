package com.zup.app.backend;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zup.app.backend.model.Connector;
import com.zup.app.backend.model.Products;

@Path("/products")
public class ProductsService {

	@GET
	@Path("/all")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllProducts() {
		String result = "========Products List========\n";
		try {
			Connector.openConnection();
			for(Products product : Connector.getAllProducts()){
				result += product.getId();
				result += "\n";
				result += product.getName();
				result += "\n";
				result += product.getDescription();
				result += "\n";
				result += product.getPrice();
				result += "\n";
				result += product.getCategory();
				result += "\n";
			}
		}catch (Exception e){
			result += e.getMessage();
		}finally{
			Connector.closeConnection();
		}

		return result;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getProduct(@PathParam("id") String id){
		String result = "========Products Found========\n";
		try {
			Connector.openConnection();
			Products product = Connector.getProduct(id);
			if(product == null){
				result  += "Product not found";
			}else{
				result += product.getId();
				result += "\n";
				result += product.getName();
				result += "\n";
				result += product.getDescription();
				result += "\n";
				result += product.getPrice();
				result += "\n";
				result += product.getCategory();
				result += "\n";
			}
		}catch (Exception e){
			result += e.getMessage();
		}finally{
			Connector.closeConnection();
		}

		return result;
	}
	
	@Path("/add")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Products addProduct(Products product) {

		if (product != null) {
			return Connector.addProduct(product) ? product : null;
		}
		
		return null;
	}



	@Path("{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Products updateProducts(@PathParam("id") String id, Products product) {
		
		if (product != null) {
			return Connector.updateProduct(id,product) ? product : null;
		}
		
		return null;
	}

	@Path("{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProductsById(@PathParam("id") String id) {
		
		if (id != null) {
			return Connector.deleteProduct(id) ? "Product has been deleted." : null;
		}
		
		return null;
	}

}
