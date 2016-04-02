package com.zup.app.backend.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import static com.mongodb.client.model.Filters.*;

public class Connector {

	//Shared variables

	private static MongoClient mongo;
	private static MongoDatabase db;
	private static MongoCollection<Document> collection;

	//Helpers

	//Closes the connection
	public static void closeConnection(){
		mongo.close();
	}

	//Open connection to MongoDB Server - All the values are for the local test
	public static void openConnection(){
		mongo = new MongoClient( "localhost" , 27017 );
		mongo.setWriteConcern(WriteConcern.W1);
		db = mongo.getDatabase("test");
		if(collectionExists("products")){
			db.createCollection("products");
		}
		collection = db.getCollection("products");
	}

	//Open connection to MongoDB Server - Option to connect to a chosen MongoDB Server
	public static void openConnection(String host, int port, String dbName, String collectionName){
		mongo = new MongoClient( host , port );
		db = mongo.getDatabase(dbName);
		collection = db.getCollection(collectionName);
	}

	//Operations

	// Get all the Product from MongoDB Collection
	public static ArrayList<Product> getAllProducts(){
		FindIterable<Document> iterable = collection.find();
		final ArrayList<Product> products = new ArrayList<Product>();
		iterable.forEach(new Block<Document>() {
			//Overrides how to process the Bson document and wraps the result in the Product Class
			@Override
			public void apply(final Document document) {
				Product product = new Product();

				for (Map.Entry<String, Object> entry : document.entrySet()){
					if(entry.getKey().equals("name")) product.setName(entry.getValue().toString());
					else if(entry.getKey().equals("description")) product.setDescription(entry.getValue().toString());
					else if(entry.getKey().equals("price")) product.setPrice(Float.parseFloat(entry.getValue().toString()));
					else if(entry.getKey().equals("category")) product.setCategory(entry.getValue().toString());
					else if(entry.getKey().equals("products_id")) product.setId(entry.getValue().toString());
					else continue;
				}

				products.add(product);
			}
		});
		return products;
	}

	// Get a product by id from MongoDB Collection
	public static Product getProduct(String id){
		Document document = collection.find(eq("products_id", id)).first();
		
		Product product = new Product();

		for (Map.Entry<String, Object> entry : document.entrySet()){
			if(entry.getKey().equals("name")) product.setName(entry.getValue().toString());
			else if(entry.getKey().equals("description")) product.setDescription(entry.getValue().toString());
			else if(entry.getKey().equals("price")) product.setPrice(Float.parseFloat(entry.getValue().toString()));
			else if(entry.getKey().equals("category")) product.setCategory(entry.getValue().toString());
			else if(entry.getKey().equals("products_id")) product.setId(entry.getValue().toString());
			else continue;
		}
		
		return product;
	}
	
	
	// Add a product to MongoDB Collection
	public static Boolean addProduct(Product product){
		try{
			collection.insertOne(product.toDocument());
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	// Update a product by id and new information from MongoDB Collection
	public static Product updateProduct(String id, Product product){
		collection.updateOne(eq("products_id", id),product.toUpdateDocument());
		
		//TODO: modify this for MongoDB clusters, this is only working for standalone applications
		return getProduct(id);
	}
	
	// Delete a product by id from MongoDB Collection
	public static Boolean deleteProduct(String id){
		DeleteResult result = collection.deleteOne(new Document("products_id", id));
		
		//TODO: modify this for MongoDB clusters, this is only working for standalone applications
		return result.getDeletedCount() > 0;
	}
	
	// Insert Many instances for testing purposes
	public static void insertMany(ArrayList<Document> documents){
		collection.insertMany(documents);
	}
	
	//Check if collection exists
	
	private static boolean collectionExists(String collectionName){
		
		Iterator<String> collectionNames = db.listCollectionNames().iterator();
		
		while(collectionNames.hasNext()){
			if(collectionNames.next().equals(collectionName)){
				return true;
			}
		}
		return false;
		
	}
}

