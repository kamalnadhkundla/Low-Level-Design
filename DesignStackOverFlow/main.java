package DesignStackOverFlow;

import DesignStackOverFlow.Entity.Question;
import DesignStackOverFlow.Entity.User;

public class main {
    public static void main(String[] args) {
        StackOverFlow instance =StackOverFlow.getInstance();


        instance.getAllQuestions();
        User user1= new User("Kamal");
        instance.addQuestion(new Question("what is string in java", user1));
        instance.getAllQuestions();

    }
    
}
