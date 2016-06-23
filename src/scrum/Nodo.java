package scrum;


import com.mongodb.BasicDBObject;
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
public class Nodo {
    private Client mDB;
    private Object _id;
    private String collection = "nodo";
    
    public Nodo(String nombre,Client mDB){
        this.mDB = mDB;
        if( this.mDB.find(this.collection,new Document("nombre",nombre)) == null){
                this.mDB.insert(this.collection, new Document("nombre",nombre));
        }
        this._id = this.mDB.find(this.collection,new Document("nombre",nombre)).get(0).get("_id");
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
    
    public void dropNodo(){
        this.mDB.remove(this.collection,new Document("_id",this._id));
        Arco a = new Arco(this.mDB);
        a.onNodeDelete(this._id);
        
    }
  
    public Object id(){
        return this._id;
    }
}
