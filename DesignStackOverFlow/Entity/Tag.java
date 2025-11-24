package DesignStackOverFlow.Entity;

import java.util.UUID;

public class Tag {
    final String Id;
   final String Name;
   
       Tag(String Name)
       {
           this.Id=UUID.randomUUID().toString();
        this.Name=Name;
    }

    String getTagId() { return this.Id;}
    String getTagName(){ return this.Name;}
    
}
