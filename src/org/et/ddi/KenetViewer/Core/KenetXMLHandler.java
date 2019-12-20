package org.et.ddi.KenetViewer.Core;

import java.util.*; 
import org.xml.sax.*; 
import org.xml.sax.helpers.DefaultHandler;

public class KenetXMLHandler extends DefaultHandler{
      
    private SynsetList synsets;
    private Synset s;
    private String synName, srID, ilrID;
    private boolean id,pos,def,example;
    private boolean syn,lit,sense;
    private boolean sr,ilr,type;
    
    public KenetXMLHandler(SynsetList _synsets){
       this.synsets = _synsets; 
       id = true; pos = false; def = false; example = false;
       syn = false; lit = false;  sense = false;
       sr = false; ilr = false; type = false;
       s = new Synset();
    }
 
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("SYNSET")) s = new Synset();
        
        if(qName.equalsIgnoreCase("ID")) id=true; 
        if(qName.equalsIgnoreCase("POS")) pos=true; 
        
        if(qName.equalsIgnoreCase("SYNONYM")) syn=true;
        if(qName.equalsIgnoreCase("LITERAL")) lit=true;  
        if(qName.equalsIgnoreCase("SENSE")) sense=true;
        
        
        if(qName.equalsIgnoreCase("SR")) sr=true;
        if(qName.equalsIgnoreCase("ILR")) ilr=true; 
        if(qName.equalsIgnoreCase("TYPE")) type=true;
        
        if(qName.equalsIgnoreCase("DEF")) def=true; 
        if(qName.equalsIgnoreCase("EXAMPLE")) example=true; 
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
       if(qName.equalsIgnoreCase("SYNSET"))  synsets.add(s); 
       if(qName.equalsIgnoreCase("ID")) id=false;  
       if(qName.equalsIgnoreCase("SYNONYM")) syn=false; 
       if(qName.equalsIgnoreCase("POS")) pos=false; 
       if(qName.equalsIgnoreCase("SR")) sr=false;
       if(qName.equalsIgnoreCase("ILR")) ilr=false;
       if(qName.equalsIgnoreCase("DEF")) def=false; 
       if(qName.equalsIgnoreCase("EXAMPLE")) example=false; 
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(id)s.ID = new String(ch, start, length); 
        if(pos) s.POSTag = new String(ch, start, length);
        if(def)s.Definition =  new String(ch, start, length);   
        if(example)s.Example = new String(ch, start, length);
        
        
        
        if (syn && lit) {
            if(sense){
                int senseID = Integer.parseInt(new String(ch, start, length));
                s.Synonyms.put(synName, senseID);
                lit = false; sense = false;
            }else{
                synName = new String(ch, start, length); 
            } 
        }  
        
        
        if(sr){
            if(type){
                String srType = new String(ch, start, length);
                s.SemanticRelations.put(srID, srType);
                sr = false; type = false;
            }else{
                srID = new String(ch, start, length);
            }
        }
        
        if(ilr){
            if(type){
                String ilrType = new String(ch, start, length);
                s.EnglishSemanticRelations.put(ilrID, ilrType);
                ilr = false; type = false;
            }else{
                ilrID = new String(ch, start, length);
            }   
        }
    }
    
}























