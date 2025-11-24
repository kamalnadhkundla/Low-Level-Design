package DesignStackOverFlow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import DesignStackOverFlow.Entity.*;

public class StackOverFlow {
    public static StackOverFlow instance;
    public static Map<Question,User> questionAuthor ;
    static List<Question> questions ;
        private StackOverFlow() {
        this.questions = new ArrayList<>();
        
    }
    Map<Question,User> map = new ConcurrentHashMap<>();

    public static StackOverFlow getInstance(){
       
        if(instance==null) {
            questions = new ArrayList<>();
           instance= new StackOverFlow(); questionAuthor = new HashMap<>();
        }
        return instance;
    }

    public void showQuestions() {
        System.out.println("\n=== All Questions ===");
        for (Question q : questions) {
          System.out.println(q.getTitle());
        }
    }

    public List<Question> getAllQuestions() {
        return questions;
    }
    public void addQuestion(Question q){
        questions.add(q);
        questionAuthor.put(q,q.getAuthor());

    }

 

  
    
}
