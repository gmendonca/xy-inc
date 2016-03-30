package com.zup.app.backend.model;


public class Products {
	
	private String name;
	private String description;
	private float price;
	private String category;
	
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

}
