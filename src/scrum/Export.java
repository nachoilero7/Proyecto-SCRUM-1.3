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

public class Export {
    Export(Client mDB, String savePath) throws IOException{
        String outTextFile = "GrafoExport.txt";
        String dotPath = ".\\dot.exe";
        String outImageFile = "GrafoExport.png";   
        File archivo = new File(savePath + "\\" + outTextFile);
        
        String graphData = "";
        
        //MAGIA
        
        String finalData = "digraph A {\n "
                + "nodesep=1.0 \n "
                + "node [fontname=ArialBlack,shape=box]\n "
                + "edge [color=Blue,style=bold]" + graphData + "}";
        FileWriter file = new FileWriter(archivo);
        BufferedWriter writeFile = new BufferedWriter(file);
        writeFile.write(finalData);
        writeFile.close();
        String comand = dotPath + " -Tpng " + outTextFile + " -o " + outImageFile;
        Runtime rt = Runtime.getRuntime();
        rt.exec( comand );
    }
    
}
