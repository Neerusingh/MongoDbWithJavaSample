package com.crater;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;  
public class MongoDbMainApplication {
private final  static String DATABASE="mentorz";
private final static Integer PORT=27017;
private final static String COLLECTION="users";
private final static String HOST="localhost";
private static MongoCollection<Document> collection;
private static MongoClient mongoClient;
	
	
	public static void main(String[] args) {
		
		    createDbAndCollection();
			Document doc= makeDocument();
			 insertDocument (doc);
			  getDocument();
			 findDocument();
			 dropCollection();
			 
		}
	
	
	public static void createDbAndCollection(){
		try{ 
		mongoClient = new MongoClient( HOST , PORT );  
		
		//---------- Creating DataBase ---------------------------//  
		MongoDatabase db = mongoClient.getDatabase(DATABASE); 
		
		//---------- Creating Collection -------------------------//  
		 collection= db.getCollection(COLLECTION); 
		 System.out.println("db and collection is created ");
		 
		}catch(Exception e){  
			System.out.println(e);  
			} 
	}
	
	
	//---------- Creating Document ---------------------------// 
	public static  Document  makeDocument(){
	   Document doc = new Document("name", "Peter John");  
		doc.append("id",12); 
		System.out.println("make document ");
		return doc;
		
		
	}
	
	//----------- Inserting Data ------------------------------// 
	public static void insertDocument(Document doc){
          collection.insertOne(doc); 
          System.out.println("insert document ");
          
         
	}
	

	
	public static void getDocument(){
	FindIterable<Document> docs=collection.find();
	
	for(Document doc:docs){

	System.out.println("get all documents json==============="+   doc.toJson());
	
	}
	}
	
	public static FindIterable<Document> findDocument(){
		
		FindIterable<Document> doc=collection.find().limit(1);
		System.out.println("find document==============="+doc.toString());
		return doc;
	}
	
	public static void dropCollection(){
		collection.drop();
		System.out.println("dropped collection  ");
	}

}
