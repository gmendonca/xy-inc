package com.zup.app.backend.helpers;

import java.util.ArrayList;

import org.bson.Document;

import com.zup.app.backend.model.Connector;
import com.zup.app.backend.model.Product;

public class InsertData {
	
	public static void main(String [] args){
		ArrayList<Document> documents = new ArrayList<Document>();
		documents.add(new Product("iPhone 6S", "This a phone made by Apple", 650.0f, "Smartphones").toDocument());
		documents.add(new Product("Nexus 6P", "This a phone made by Google", 500.0f, "Smartphones").toDocument());
		documents.add(new Product("MacBook Pro", "This a laptop made by Apple", 2000.0f, "Laptops").toDocument());
		documents.add(new Product("Lenovo X1", "This a laptop made by Lenovo", 1800.0f, "Laptops").toDocument());
		documents.add(new Product("Kindle Paperwhite", "This a phone made by Amazon", 650.0f, "E-readers").toDocument());
		documents.add(new Product("iPad Air 2", "This a tablet made by Apple", 399.0f, "Tablets").toDocument());
		documents.add(new Product("Samsung Galaxy Tab 4", "This a tablet made by Samsung", 200.0f, "Tablets").toDocument());
		
		try{
			Connector.openConnection();
			Connector.insertMany(documents);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			Connector.closeConnection();
		}
	}
	
	

}
