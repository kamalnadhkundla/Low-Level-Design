package DesignStackOverFlow.Entity;

import java.util.UUID;

class Comment extends PostEntity {
  
    public Comment(User Author,String message) {
     super(UUID.randomUUID().toString(),message,Author);
    }
}

