package org.et.ddi.KenetViewer.Core;

import java.util.*;

public class Synset {
    
    public String ID;
    public HashMap<String,Integer> Synonyms;
    public String POSTag;
    public HashMap<String,String> SemanticRelations;
    public HashMap<String,String> EnglishSemanticRelations;
    public String Definition;
    public String Example;
    
    
    public Synset(){
        Synonyms= new HashMap<>();
        SemanticRelations = new HashMap<>();
        EnglishSemanticRelations = new HashMap<>();
    }

    
}





