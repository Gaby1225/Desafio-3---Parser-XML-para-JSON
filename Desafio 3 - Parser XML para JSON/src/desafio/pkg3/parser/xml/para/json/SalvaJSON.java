/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio.pkg3.parser.xml.para.json;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gabrielle
 */
public class SalvaJSON {

    
    public void formataJson(ArrayList<Objetojson> obj) throws IOException{
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("{\n");
        sb.append("\"" + obj.get(0).getTag() + "\": {\n");
        obj.remove(0);
        sb.append("\"" + obj.get(0).getTag() + "\": [\n{\n");
        
        String tagVetor = obj.get(0).getTag();
        obj.remove(0);
        
        Objetojson anterior = new Objetojson();
        
        for (Objetojson o : obj){
            if(o.getTag().equals(tagVetor)){
                sb.append("\n},\n{\n");
                anterior = o;
                continue;
            }else if(anterior.getValor() == null){
                sb.append("\"" + o.getTag() + "\": \"" + o.getValor() + "\"");
                anterior = o;
                continue;
            }else if(o.getValor() != null){
                sb.append(",\n");
                anterior = o;
            }
            
            sb.append("\"" + o.getTag() + "\": \"" + o.getValor() + "\"");
            
        }
        sb.append("\n}\n]\n}\n}");
        
        File arqJson = new File("arqJson.json");
        
        if(arqJson.exists()){
            arqJson.delete();            
        }
        
        arqJson.createNewFile();
        
        try(FileWriter writer = new FileWriter("arqJson.json")){
            writer.write(sb.toString());
        }
        System.exit(0);
    }
}
