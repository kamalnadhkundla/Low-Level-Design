package DesignStackOverFlow.strategy;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import DesignStackOverFlow.Entity.Question;
import DesignStackOverFlow.Entity.Tag;

public class TagWordSearchStrategy implements SearchStrategy{
public Tag tag;
TagWordSearchStrategy(Tag tag) {this.tag=tag;}
@Override
public List<Question> search(List<Question> questions) {
    // TODO Auto-generated method stub
   return questions.stream().filter(q->q.getTags().contains(tag)).collect(Collectors.toList());
}    
}
