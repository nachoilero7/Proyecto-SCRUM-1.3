package scrum;


import scrum.Nodo;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.Hashtable;
import org.bson.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Arco {
   
    private Document atributos;
    Client mDB;
    String collection = "arco";
    Object _id;
    
    public Arco(Client mDB){
        this.mDB = mDB;
    }
    
    
    public boolean ciclo(Object origen,Object destino){
       boolean vali = false;
       if(this.mDB.find(this.collection,new Document("origen",destino).append("destino",origen)) != null)
               vali=true;
       else{
           ArrayList<Document> documents = this.mDB.find(this.collection,new Document("origen",destino));
           int i=0;
           if(documents != null){
              while(i < documents.size() && !vali){
               vali = ciclo(origen, documents.get(i).get("destino"));
               i++;
             } 
           }
       }
       
      return vali;                 
    }
    public void agregarArco(Nodo a, Nodo b){
        
        if( this.mDB.find(this.collection,new Document("origen",a.id()).append("destino",b.id())) == null && !ciclo(a.id(),b.id())){
             this.mDB.insert(this.collection, new Document("origen",a.id()).append("destino",b.id()));
        }
        //this._id = this.mDB.find(this.collection,new Document("origen",a.id()).append("destino",b.id())).get(0).get("_id");
        
     
    
    }
    

    
    public void agregarAtributo(String clave, Object valor){
       if(this.mDB.find(this.collection,new Document("_id",this._id).append(clave, valor)) != null){
            //cartel: ya tiene ese atributo.(esto es para la interfaz)
        
        }
        else{
            this.mDB.update(this.collection,new Document("_id",this._id),new Document(clave,valor));
            
            //cartel: atributo agregado.(esto es para la interfaz)
        }
    }
    
      public void modificarAtributo(String clave, Object valor){
            this.mDB.update(this.collection,new Document("_id",this._id),new Document(clave,valor));
    }
 
    public void eliminarAtributo(String clave){
       this.mDB.updateAttr(this.collection,new Document("_id",this._id),new Document(clave,""));
    }
    
    
    public Object devolverAtributo(String clave){
        return this.mDB.find(this.collection,new Document("_id",this._id)).get(0).get(clave);
    }
    
     public void dropArco(){
        this.mDB.remove(this.collection,new Document("_id",this._id));
    }
     
     public void onNodeDelete(Object id){
         this.mDB.remove(this.collection,new Document("origen",id));
         this.mDB.remove(this.collection,new Document("destino",id));
     }
  
    public Object id(){
        return this._id;
    }
}

