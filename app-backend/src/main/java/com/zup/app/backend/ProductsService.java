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
	
	/*
	 * Use annotations to produce a JSON with all the products using GET
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			products = Connector.getAllProducts();
		}catch (Exception e){
			return null;
		}

		return products;
	}
	
	/*
	 * Use annotations to produce a JSON with a products 
	 * using GET and an id as input
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("id") String id){
		try {
			return Connector.getProduct(id);
		}catch (Exception e){
			return null;
		}
	}
	
	/*
	 * Use annotations to produce a JSON with a product that you want to store
	 * using POST and a JSON as an input
	 */
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product addProduct(Product product) {
		if (product != null) {
			try {
				return Connector.addProduct(product) ? product : null;
			}catch (Exception e){
				return null;
			}
		}
		return null;
	}

	/*
	 * Use annotations to produce a JSON with a product that you want 
	 * to update using PUT and a JSON as an input
	 */
	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product updateProducts(@PathParam("id") String id, Product product) {
		if (product != null) {
			try {
				return Connector.updateProduct(id,product);
			}catch (Exception e){
				return null;
			}
		}
		
		return null;
	}
	
	/*
	 * Use annotations to produce a JSON with all the products 
	 * using DELETE and getting an id as input
	 */
	@Path("{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteProductsById(@PathParam("id") String id) {
		if (id != null) {
			try {
				return Connector.deleteProduct(id) ? "Product has been deleted." : null;
			}catch (Exception e){
				return null;
			}
		}
		
		return null;
	}

}
