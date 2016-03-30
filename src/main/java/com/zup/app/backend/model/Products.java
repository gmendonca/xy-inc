package com.zup.app.backend.model;

import java.util.Random;

import org.bson.Document;


public class Products {
	
	private String id;
	private String name;
	private String description;
	private float price;
	private String category;
	
	//constructors
	public Products(){
		this.id = String.format("%06d", new Random().nextInt(999999) + 1);
	}
	
	//getters
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
	
	//setters
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
	
	//Create a Bson document for the object
	public Document toDocument(){
		return new Document("products_id", this.id)
						.append("name", this.name)
						.append("description", this.description)
						.append("price", this.price)
						.append("category", this.category);
	}

}
