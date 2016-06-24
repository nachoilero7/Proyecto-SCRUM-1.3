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
/**
 *
 * @author DiegoMSI
 */
public class Import {
    Import(Client mDB, String importPath ) throws FileNotFoundException, IOException{
    String fileData = new Scanner(new File(importPath)).useDelimiter("\\Z").next();
    
    String nodos = fileData.split(">>>>>>>>>>")[1].substring(fileData.split(">>>>>>>>>>")[2].lastIndexOf("<")+1);
    String arcos = fileData.split(">>>>>>>>>>")[2].substring(fileData.split(">>>>>>>>>>")[2].lastIndexOf("<")+1);
    
    for(int i=0; i < nodos.split("----------").length - 1; i++){
       String nodo = nodos.split("----------")[i];
       System.out.print(i + " " +nodo); 
    }
    
    

    }
}
