package com.zup.app.backend;

import java.util.ArrayList;

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
import com.zup.app.backend.model.Product;

@Path("/products")
public class ProductsService {

	@GET
	@Path("/all")
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

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("id") String id){
		try {
			Connector.openConnection();
			return Connector.getProduct(id);
		}catch (Exception e){
			return null;
		}finally{
			Connector.closeConnection();
		}
	}
	
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product addProduct(Product product) {
		if (product != null) {
			try {
				Connector.openConnection();
				return Connector.addProduct(product) ? product : null;
			}catch (Exception e){
				return null;
			}finally{
				Connector.closeConnection();
			}
		}
		return null;
	}



	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product updateProducts(@PathParam("id") String id, Product product) {
		if (product != null) {
			try {
				Connector.openConnection();
				return Connector.updateProduct(id,product);
			}catch (Exception e){
				return null;
			}finally{
				Connector.closeConnection();
			}
		}
		
		return null;
	}

	@Path("{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteProductsById(@PathParam("id") String id) {
		if (id != null) {
			try {
				Connector.openConnection();
				return Connector.deleteProduct(id) ? "Product has been deleted." : null;
			}catch (Exception e){
				return null;
			}finally{
				Connector.closeConnection();
			}
		}
		
		return null;
	}

}