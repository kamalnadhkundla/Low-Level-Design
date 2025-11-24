package DesignStackOverFlow.Entity;

import java.lang.reflect.Member;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class PostEntity {
     protected int entityId;
    protected User createdBy;
    protected LocalDate createdDate;
   protected String id;
   protected String body;
  
  

public PostEntity(String id,String body,User Author){
    this.id=id;
    this.createdBy = Author; this.body=body;
    this.createdDate = LocalDate.now();

}

  
public String getAuthorId(){
   
    return this.createdBy.getId();
}
public User getAuthor(){
    return this.createdBy;
}
    
}
