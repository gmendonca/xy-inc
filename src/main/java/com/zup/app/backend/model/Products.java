package com.zup.app.backend.model;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Products {
	
	private String name;
	private String description;
	private float price;
	private String category;
	
	private MongoClient mongo;
	private MongoDatabase db;
	private MongoCollection<Document> collection;
	
	public Products(){
		mongo = new MongoClient( "localhost" , 27017 );
		db = mongo.getDatabase("test");
		collection = db.getCollection("products");
	}
	
	//helpers
	public void closeConnection(){
		mongo.close();
	}
	
	//getters
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public float getPrice() {
		return price;
	}
	
	public String getCategory() {
		return category;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	//operations
	public ArrayList<String> getAllProducts(){
		FindIterable<Document> iterable = collection.find();
		final ArrayList<String> products = new ArrayList<String>();
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        products.add(document.toString());
		    }
		});
		return products;
	}
	
	

}
