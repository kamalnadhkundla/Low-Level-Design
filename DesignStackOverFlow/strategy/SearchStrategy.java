package DesignStackOverFlow.strategy;
import DesignStackOverFlow.Entity.*;
import java.util.*;
public interface SearchStrategy {

    List<Question> search(List<Question> questions);
    
}
