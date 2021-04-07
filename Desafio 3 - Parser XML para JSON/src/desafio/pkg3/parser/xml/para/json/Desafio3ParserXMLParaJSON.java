/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio.pkg3.parser.xml.para.json;

/**
 *
 * @author Gabrielle
 */
public class Desafio3ParserXMLParaJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        LeXML lexml = new LeXML();
        SalvaJSON salvajson = new SalvaJSON();
        salvajson.formataJson(lexml.CarregaVerifica());
   }
    
}
