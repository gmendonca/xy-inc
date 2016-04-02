package com.zup.app.backend.model;

import java.util.Random;

import org.bson.Document;


public class Product {
	
	private String id;
	private String name;
	private String description;
	private Float price;
	private String category;
	
	//Constructors
	public Product(){
		this.id = String.format("%06d", new Random().nextInt(999999) + 1);
	}
	
	public Product(String name, String description, Float price, String category){
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}
	
	//Getters
	public String getId() {
		return id;
	}
	
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
	
	//Setters
	public void setId(String id) {
		this.id = id;
	}
	
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
	
	//Helpers
	
	/*
	 * Create a Bson document for the object
	 */
	public Document toDocument(){
		return new Document("products_id", this.id)
						.append("name", this.name)
						.append("description", this.description)
						.append("price", this.price)
						.append("category", this.category);
	}
	
	/*
	 * Create a Bson document for the Update the MongoDB instance
	 */
	public Document toUpdateDocument(){
		Document doc = new Document();
		if(this.name != null) doc.append("name", this.name);
		if(this.description != null) doc.append("description", this.description);
		if(this.price != null) doc.append("price", this.price);
		if(this.category != null) doc.append("category", this.category);
		return new Document("$set",doc);

	}

}
