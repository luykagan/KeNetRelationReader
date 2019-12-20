package org.et.ddi.KenetViewer.Core;

import java.io.*;  
import javax.swing.*;
import javax.xml.parsers.*;

public class KeNetSourceLoader {
    
    public SynsetList Synsets;
    
    public KeNetSourceLoader(){
        Synsets = new SynsetList();
    } 
    
    public void loadKeNetSynsetData(){ 
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            KenetXMLHandler handler = new KenetXMLHandler(Synsets); 
            InputStream is = new FileInputStream( new File("turkish_wordnet.xml"));
            parser.parse(is,handler); 
        }catch(Exception ex){ex.printStackTrace();} 
    } 

    public ListModel<String> getSynsetList(DefaultListModel model) {
        DefaultListModel dlm= model;
        dlm.removeAllElements(); 
        for(Synset s:Synsets.Synsets)dlm.addElement(s.ID); 
        return (ListModel)dlm;
    }

    public Synset getSynset(String synID) {
        return Synsets.getSynset(synID);
    }
    
}












