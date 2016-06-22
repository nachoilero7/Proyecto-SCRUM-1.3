/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author DiegoMSI
 */
public class SCRUM {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("graphDB");
        
    }
    
}
