
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class GrafoDirigido {
    
    private Vector<Nodo> nodos;
    private Vector<Arco> arcos;
    /*
    ...
    */
    
    
    
    public Arco buscarArco (String tema1, String tema2){
       	
    	
    	
    }
    
    
    public Nodo buscarNodo(String tema)
    {
    	  for(int i = 0; i<nodos.size(); i++){
              if(nodos.get(i).getTema().equals(tema)){
                  return nodos.elementAt(i);
              }
    	  }
    	  return null;
    }
    	
    
    public agregarAtributoArco(String tema1,String tema2, String clave, Object valor)
    {
    	Arco a = buscarArco(tema1,tema2);
    	
    	if (a!null)
    	{
    		a.agregarAtributo(clave,valor);
    	}
    	
    }
    
    public setAtributoArco(String tema1,String tema2, String clave, Object valor)
    {
    	Arco a = buscarArco(tema1,tema2);
    	
    	if (a!null)
    	{
    		a.modificarAtributo(clave,valor);
    	}
    	
    }
    
    public agregarAtributoNodo(String tema, String clave, Object valor)
    {
    	Nodo n = buscarNodo(tema);
    	
    	if (n!null)
    	{
    		n.agregarAtributo(clave,valor);
    	}
    	
    }
    
    
    public eliminarAtributoArco(String tema1,String tema2, String clave)
    {
    	Arco a = buscarArco(tema1,tema2);
    	
    	if (a!null)
    	{
    		a.eliminarAtributo(clave);
    	}
    	
    }
    public eliminarAtributoNodo(String tema, String clave)
    {
    	Nodo n = buscarNodo (tema);
    	
    	if (n!null)
    	{
    		n.eliminarAtributo(String clave);
    	}
    	
    }
 
    public setAtributoNodo(String tema, String clave, Object valor)
    {
    	Nodo n = buscarNodo (tema);
    	
    	if (n!null)
    	{
    		n.modificarAtributo(String clave);
    	}
    	
    }
    
    
    public void crearNodo(String tema){
        Nodo n = new Nodo(tema);
        nodos.add(n);

    }
    
    public void eliminarNodo(String tema){
    	//Primero elimino el arco ya que si se hace luego de elimar el nodo, no hay forma de verificar que arco es.
    	  for(int i = 0; i<arcos.size(); i++){
              if(arcos.get(i).getNodo1().getTema().equals(tema)
                  || arcos.get(i).getNodo2().getTema().equals(tema)){
                  arcos.remove(i);
              }
          }
    	    	 
        for(int i = 0; i<nodos.size(); i++){
            if(nodos.get(i).getTema().equals(tema)){
                nodos.remove(i);
            }
        }
      
    }
    
    public void modificarNodo(String tv, String tn){
        for(int i = 0; i<nodos.size(); i++){
            if(nodos.get(i).getTema().equals(tv)){
                nodos.get(i).setTema(tn);
            }
        }
    }
    
}
