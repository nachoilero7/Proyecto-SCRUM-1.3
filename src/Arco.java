
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
public class Arco {
    
    private Nodo n1;
    private Nodo n2;
    private Hashtable<String,Object> atributos;
    
    public Arco(Nodo a, Nodo b){
        n1 = a;
        n2 = b;
        atributos = new Hashtable<String,Object>();
    }
    
    public Nodo getNodo1(){
        return n1;
    }
    
    public Nodo getNodo2(){
        return n2;
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
        dBObj.append("nodo1", n1.toDBObject());
        dBObj.append("nodo2", n2.toDBObject());
        dBObj.append("atributos",atributos);
        return dBObj;
    }
}
