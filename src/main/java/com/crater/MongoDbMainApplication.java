package com.crater;

import java.util.Scanner;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoDbMainApplication {
	private final static String DATABASE = "mentorz";
	private final static Integer PORT = 27017;
	private final static String COLLECTION = "users";
	private final static String HOST = "localhost";
	private static MongoCollection<Document> collection;
	private static MongoClient mongoClient;
	private static MongoDatabase db;
	private static Scanner sc;

	public static void main(String[] args) {

		/**
		 * operations to perform on database,if u do not want to perform any
		 * below operations please comment that
		 */

		/**
		 * create Db and collection
		 */
		createDbAndCollection();

		/**
		 * retrieve all existing collections
		 */
		getCollection();

		/**
		 * make document,u can simple get data from api's in restfull services
		 */
		Document doc = makeDocument();

		/**
		 * insert document in collection
		 */
		insertDocument(doc);

		/**
		 * retrieve all documents in particular collection
		 */
		getDocument();

		/**
		 * find a specified document
		 */
		findDocument();

		/**
		 * get database name
		 */
		getDatabase();

		/**
		 * get port
		 */
		getPort();
		/**
		 * get host name
		 */
		getHost();
		/**
		 * get Db
		 */
		
		getDb();
		
		/**
		 * drop collection
		 */
		dropCollection();

	}

	public static void createDbAndCollection() {
		try {
			mongoClient = new MongoClient(HOST, PORT);

			// ---------- Creating DataBase ---------------------------//
			db = mongoClient.getDatabase(DATABASE);

			// ---------- Creating Collection -------------------------//
			collection = db.getCollection(COLLECTION);
			System.out.println("successfully created Db and Collection");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// ---------- Creating Document ---------------------------//
	public static Document makeDocument() {
		sc = new Scanner(System.in);
		System.out.println("Enter name");
		String str = sc.nextLine();
		System.out.println("Inter  UserId");
		Integer id = sc.nextInt();
		Document doc = new Document("name", str);
		doc.append("id", id);
		System.out.println("successfully created document ");
		return doc;

	}

	// ----------- Inserting Data ------------------------------//
	public static void insertDocument(Document doc) {
		collection.insertOne(doc);
		System.out.println("successfully inserted document in collection " + collection);
	}

	public static void getDocument() {
		FindIterable<Document> docs = collection.find();

		for (Document doc : docs) {

			System.out.println("Document= " + doc.toJson());

		}
	}

	public static void getCollection() {

		MongoIterable<String> collections = getDb().listCollectionNames();
		for (String str : collections) {
			System.out.println("Collection = " + str);
		}
	}

	public static String getDatabase() {
		System.out.println("Database= " + DATABASE);
		return DATABASE;
	}

	public static Integer getPort() {
		System.out.println("Port= " + PORT);
		return PORT;
	}

	public static String getHost() {
		System.out.println("Host= " + HOST);
		return HOST;
	}



	public static MongoDatabase getDb() {
		return db;
	}



	public static FindIterable<Document> findDocument() {

		Document doc = new Document("name", "vishal");

		FindIterable<Document> doc1 = collection.find(doc);

		System.out.println("Doc" + doc1.first());

		return doc1;
	}

	public static void dropCollection() {
		collection.drop();
		System.out.println("dropped collection  ");
	}

}
