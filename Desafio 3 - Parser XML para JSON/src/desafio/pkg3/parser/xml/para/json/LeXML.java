/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio.pkg3.parser.xml.para.json;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gabrielle
 */
public class LeXML {
    
    public ArrayList<Objetojson> CarregaVerifica() throws Exception {
        
        
        ArrayList<Objetojson>  listaCxml = new ArrayList<Objetojson>();
        FileDialog dialogFile = new FileDialog((Frame) null, "Select File to Open");
        dialogFile.setMode(FileDialog.LOAD);
        dialogFile.setVisible(true);
        String file = dialogFile.getDirectory() + dialogFile.getFile();
        if (dialogFile.getFile() == null) {
            System.exit(0);
        }
        File enter = new File(file);
        Scanner scanner = new Scanner(enter);  
             
        boolean pular = false;
        boolean tag = false;
        StringBuilder sb = new StringBuilder();
        Objetojson ojson = new Objetojson();
        
        while(scanner.hasNextLine()){
            
            for(char testChar : scanner.nextLine().toCharArray()){
                
                if(testChar == '<'){
                    tag = true;
                    pular = false;
                    if(sb.length() > 0){
                        listaCxml.get(listaCxml.size() - 1).setValor(sb.toString());
                        sb.setLength(0);
                    }
                    //listaCxml.add(linha);
                }else if(testChar == '>' && tag){
                    ojson = new Objetojson();
                    ojson.setTag(sb.toString());
                    sb.setLength(0);
                    tag = false;
                   listaCxml.add(ojson);
                } else if (testChar == '/' && tag){
                    tag = false;
                    pular = true;
                }
                else if(!pular){
                    sb.append(testChar);
                }                
            }
        }
        return listaCxml;
    }
}
