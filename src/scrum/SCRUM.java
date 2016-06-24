/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import java.io.IOException;
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
   
        
      /*Client mongoClient= new Client("localhost",27017,"test");
      ArrayList<Document> graphs = mongoClient.find();
      for(int i=0; i < graphs.size(); i++){
          System.out.print("\n" + graphs.get(i));
      }
      
      */
     public static void main(String args[]) throws IOException {
         Client mongo = new Client("localhost",27017,"test");
         
         Nodo cm = new Nodo("CM",mongo);
         Nodo pp = new Nodo("PP",mongo);
         Nodo ma = new Nodo("MA",mongo);
         Nodo qa = new Nodo("QA",mongo);
         
         Arco cm_pp = new Arco(mongo);
         cm_pp.agregarArco(ma, qa);  
         Arco cm_ma = new Arco(mongo);
         cm_ma.agregarArco(cm, ma);
         Arco pp_ma = new Arco(mongo);
         pp_ma.agregarArco(pp, ma);
         //Export e = new Export(mongo, "d:");
         Import i = new Import(mongo, "d:\\GrafoExport.txt");
    }

   
    
}
