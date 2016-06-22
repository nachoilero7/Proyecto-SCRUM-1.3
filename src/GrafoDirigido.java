
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
    
    public void crearNodo(String tema){
        Nodo n = new Nodo(tema);
        nodos.add(n);
    }
    
    public void eliminarNodo(String tema){
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
