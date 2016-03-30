package com.zup.app.backend;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
		String result = "---Products List---\n";
		try {
			Connector.openConnection();
			for(Products product : Connector.getAllProducts()){
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

}
