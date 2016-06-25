/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.bson.Document;
/**
 *
 * @author DiegoMSI
 */
public class Import {
    public Import(Client mDB, String importPath ) throws FileNotFoundException, IOException{
    String fileData = new Scanner(new File(importPath)).useDelimiter("\\Z").next();
    
    String nodos = fileData.split(">>>>>>>>>>")[1].substring(fileData.split(">>>>>>>>>>")[2].lastIndexOf("<")+1);
    String arcos = fileData.split(">>>>>>>>>>")[2].substring(fileData.split(">>>>>>>>>>")[2].lastIndexOf("<")+1);
    
    for(int i=0; i < nodos.split("----------").length - 1; i++){
       String nodo = nodos.split("----------")[i];
       Document d = new Document();
       for(int j=1; j < nodo.split("\n").length ; j++){
           String campo = nodo.split("\n")[j];
           String clave = campo.split(": ")[0];
           String valor = campo.split(": ")[1];
           d.append(clave, valor);
       }
       Nodo n = new Nodo(d.getString("nombre"),mDB);
       for(String clave : d.keySet()){
           if(!clave.equals("nombre"))
               n.agregarAtributo(clave, d.get(clave));
       }
    }
    for(int i=0; i < arcos.split("----------").length ; i++){
       String arco = arcos.split("----------")[i];
       Document d = new Document();
       for(int j=1; j < arco.split("\n").length ; j++){
           String campo = arco.split("\n")[j];
           if(campo.contains(": ")){
                String clave = campo.split(": ")[0];
                String valor = campo.split(": ")[1];
                d.append(clave, valor);
           }
           else{
               String orig = campo.split(" -> ")[0];
               String dest = campo.split(" -> ")[1];
               dest = dest.substring(0, dest.length() -1);
               Nodo ori = new Nodo(orig,mDB);
               Nodo des = new Nodo(dest,mDB);            
               Arco a = new Arco(mDB);
               a.agregarArco(ori, des);
               for(String clave : d.keySet()){
                    if(!clave.equals("origen") && !clave.equals("destino"))
                    a.agregarAtributo(clave, d.get(clave));
                    }
                }    
       }
    }
    }
}
