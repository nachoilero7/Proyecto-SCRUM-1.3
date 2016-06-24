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
 
    
    public void insert(String collection, Document document){
            this.db.getCollection(collection).insertOne(document);
    }
    
  
    public ArrayList<Document> find(String collection,Document query){
        ArrayList<Document> documents = new ArrayList<>();
        FindIterable<Document> iterable = db.getCollection(collection).find(query);
        iterable.forEach(new Block<Document>(){
            @Override
            public void apply(final Document document) {
                documents.add(document);
            }
            
        });
        if(documents.isEmpty())
            return null;
        else
            return documents;
    }
    @SuppressWarnings("empty-statement")
    
     public ArrayList<Document> find(String collection){
        ArrayList<Document> documents = new ArrayList<>();
       
        FindIterable<Document> iterable = db.getCollection(collection).find();
        iterable.forEach(new Block<Document>(){
            @Override
            public void apply(final Document document) {
                documents.add(document);
                
            }
            
        });
        if(documents.isEmpty())
            return null;
        else
            return documents;
    }
    
     public void remove(String collection,Document document){
         db.getCollection(collection).deleteMany(document);
         
     }
     
     public void update(String collection,Document dO, Document dU){
         db.getCollection(collection).updateOne(dO,new Document("$set",dU));
     }
     
     public void updateAttr(String collection,Document dO, Document dU){
         db.getCollection(collection).updateOne(dO,new Document("$unset",dU));
     }
}
