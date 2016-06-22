/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import org.bson.Document;
import java.text.ParseException;
import java.util.ArrayList;


/**
 *
 * @author DiegoMSI
 */
public class SCRUM {

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws ParseException {
        
      Client mongoClient= new Client("localhost",27017,"test");
      ArrayList<Document> graphs = mongoClient.find();
      for(int i=0; i < graphs.size(); i++){
          System.out.print("\n" + graphs.get(i));
      }
      
      
        
    }
    
}
