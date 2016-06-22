package scrum;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


import static java.util.Arrays.asList;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import java.util.ArrayList;


/**
 *
 * @author matias
 */

public class Client{
    String dir = "";
    int port = 0;
    MongoClient mongoClient;
    MongoDatabase db;
    
    Client(String dir,int port,String nameDB){
        this.dir = dir;
        this.port = port;
        this.mongoClient = new MongoClient(this.dir, this.port);
        this.db = mongoClient.getDatabase(nameDB);
       
    }
 
    
    public void insert(Document document){
            this.db.getCollection("graph").insertOne(document);
    }
    
  
    public ArrayList<Document> find(Document query){
        ArrayList<Document> documents = new ArrayList<>();
        FindIterable<Document> iterable = db.getCollection("graph").find(query);
        iterable.forEach(new Block<Document>(){
            @Override
            public void apply(final Document document) {
                documents.add(document);
            }
            
        });
        return documents;
    }
    @SuppressWarnings("empty-statement")
    
     public ArrayList<Document> find(){
        ArrayList<Document> documents = new ArrayList<>();
        FindIterable<Document> iterable = db.getCollection("graph").find();
        iterable.forEach(new Block<Document>(){
            @Override
            public void apply(final Document document) {
                documents.add(document);
            }
            
        });
        return documents;
    }
    
     public void remove(Document document){
         db.getCollection("graph").deleteMany(document);
     }
     
     public void update(Document dO, Document dU){
         db.getCollection("graph").updateOne(dO,new Document("$set",dU));
     }
}
