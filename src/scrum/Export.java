/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author DiegoMSI
 */
public class Export {
    public Export(Client mDB, String savePath) throws IOException{
        String outTextFile = savePath;
        String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
        String outImageFile =  "d:\\GrafoExport.png";   
        String gvFile = "d:\\gvData.txt";

        ArrayList<Document> nodos = mDB.find("nodo"); 
        ArrayList<Document> arcos = mDB.find("arco"); 
        String gvData = "";
        String nodeData = "";
        String edgeData = "";
        String graphData = ">>>>>>>>>> NODOS <<<<<<<<<<\n";
        for(int i=0; i < nodos.size(); i++){
            Document attr = nodos.get(i);
            for(String clave : attr.keySet()){
               if(!clave.equals("_id")){
                   if( clave.equals("nombre"))
                        gvData += attr.get(clave) +";\n";
                   nodeData = clave + ": " +  attr.get(clave) + "\n"; 
                   graphData = graphData + nodeData;
               }
            };
            graphData = "\n" + graphData + "----------\n";
        }
        graphData = graphData + ">>>>>>>>>> ARCOS <<<<<<<<<<\n";
        for(int i=0; i < arcos.size(); i++){
            Document attr = arcos.get(i);
            for(String clave : attr.keySet()){
                if(!clave.equals("_id")){
                    if(clave.equals("origen")){
                        gvData += attr.get(clave);
               }
                    if(clave.equals("destino")){
                        gvData += " -> " + attr.get(clave) + ";\n";
               }
                    if(!clave.equals("origen") && !clave.equals("destino")){
                        edgeData = clave + ": " +  attr.get(clave) + "\n"; 
                        graphData = graphData + edgeData;
                    }
               }
            };
            graphData += gvData.split("\n")[gvData.split("\n").length-1] + "\n";
            graphData = "\n" + graphData + "----------\n";
        } 
        System.out.print(graphData);
        //System.out.print(gvData); 
        String finalData = "digraph A {\n "
                + "nodesep=1.0 \n "
                + "node [fontname=ArialBlack,shape=circle]\n "
                + "edge [color=Blue,style=bold]" + gvData + "}";
        
        Runtime rt = Runtime.getRuntime();
        
        File outText = new File(outTextFile);
        FileWriter outTextFW = new FileWriter(outText,false);
        BufferedWriter writeFile = new BufferedWriter(outTextFW);
        writeFile.write(graphData.trim());
        writeFile.close();
        File graphVizFile = new File(gvFile);
        FileWriter gvFW = new FileWriter(graphVizFile,false);
        BufferedWriter gvBW = new BufferedWriter(gvFW);
        gvBW.write(finalData.trim());
        gvBW.close();
        try{
        
        String comand = dotPath + " -Tpng " + gvFile + " -o " + outImageFile;
        rt.exec( comand );
        }   catch (Exception ex) {
        ex.printStackTrace();
        }
    }
    
}
