package org.et.ddi.KenetViewer.Core;
 
import java.util.*;

public class SynsetList {
    
    public ArrayList<Synset> Synsets;
    public HashMap<String, Integer> SynsetOrders;
 
    
    public SynsetList(){
        Synsets = new ArrayList<>();
        SynsetOrders = new HashMap<>();
    }
    
    public void add(Synset _syn){
       int order =  Synsets.size();
       Synsets.add(_syn);
       SynsetOrders.put(_syn.ID, order);
    }

    Synset getSynset(String synID) {
        return Synsets.get(SynsetOrders.get(synID));
    }
    
}




