
import com.mongodb.BasicDBObject;
import java.util.Hashtable;

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
    
    private String tema;
    private Hashtable<String,Object> atributos;
    
    public Nodo(String nombre){
        tema = nombre;
        atributos = new Hashtable<String,Object>();
    }
    
    public String getTema(){
        return tema;
    }
    
    public void setTema(String tn){
        tema = tn;
    }
    
    public void agregarAtributo(String clave, Object valor){
        if(atributos.containsKey(clave)){
            //cartel: ya tiene ese atributo.(esto es para la interfaz)
        }
        else{
            atributos.put(clave, valor);
            //cartel: atributo agregado.(esto es para la interfaz)
        }
    }
    
    public void modificarAtributo(String clave, Object valor){
        if(atributos.containsKey(clave)){
            atributos.replace(clave, valor);
            //cartel: atributo modificado.(esto es para la interfaz)
        }
        else{
            atributos.put(clave, valor);
            //cartel: se agrego como nuevo atributo.(esto es para la interfaz)
        }
    }
    
    public void eliminarAtributo(String clave){
        if(atributos.containsKey(clave)){
            atributos.remove(clave);
            //cartel: atributo eliminado.(esto es para la interfaz)
        }
        else{
            //cartel: atributo inexistente.(esto es para la interfaz)
        }
    }
    
    public BasicDBObject toDBObject() {
        BasicDBObject dBObj = new BasicDBObject();
        dBObj.append("tema", this.getTema());
        dBObj.append("atributos",atributos);
        return dBObj;
    }
}
