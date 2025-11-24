package DesignStackOverFlow.strategy;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import DesignStackOverFlow.Entity.Question;

public class KeyWordSearchStrategy implements SearchStrategy{
    String Keyword;
    KeyWordSearchStrategy(String key){this.Keyword=key;}

 
   public List<Question> search(List<Question> questions){
    
      return questions.stream().filter(q->q.getTitle().toLowerCase().contains(Keyword)).collect(Collectors.toList());
   } 
    
}
