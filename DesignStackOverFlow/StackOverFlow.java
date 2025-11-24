package DesignStackOverFlow;

import DesignStackOverFlow.Entity.*;
import DesignStackOverFlow.Observer.PostObserver;
import DesignStackOverFlow.Observer.reputationManager;
import DesignStackOverFlow.Types.VoteType;
import DesignStackOverFlow.strategy.SearchStrategy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverFlow {

   
    private static StackOverFlow instance;

   
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final Map<String, Question> questions = new ConcurrentHashMap<>();
    private final Map<String, Answer> answers = new ConcurrentHashMap<>();

  
    private final PostObserver reputationObserver = new reputationManager();

    
    private StackOverFlow() {}

   
    public static synchronized StackOverFlow getInstance() {
        if (instance == null)
            instance = new StackOverFlow();
        return instance;
    }

   
    public User createUser(String name) {
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    

    public Question postQuestion(String userId, String title) {
        User author = users.get(userId);

        Question question = new Question(title, author);
       

        questions.put(question.getId(), question);
        return question;
    }

   

    public Answer postAnswer(String userId, String questionId, String body) {
        User author = users.get(userId);
        Question question = questions.get(questionId);

        Answer answer = new Answer(body, author);
       
        question.addAnswer(answer);
        answers.put(answer.getId(), answer);

        return answer;
    }

   

    public void vote(String userId, String postId, VoteType voteType) {
        User voter = users.get(userId);
        PostEntity post = findPostById(postId);
        Vote vote = new Vote(voter, voteType);

        if (post instanceof Question q) {
            q.addVote(vote);
        } else if (post instanceof Answer a) {
            a.addVote(vote);
        }
    }


    public void acceptAnswer(String questionId, String answerId) {
        Question question = questions.get(questionId);
        Answer answer = answers.get(answerId);

        question.acceptAnswer(answer);
    }


    public List<Question> search(List<SearchStrategy> strategies) {
        List<Question> result = new ArrayList<>(questions.values());

        for (SearchStrategy strategy : strategies) {
            result = strategy.search(result);
        }

        return result;
    }


    public User getUser(String id) { return users.get(id); }
    public Question getQuestion(String id) { return questions.get(id); }

    public List<Question> getAllQuestions() {
        return new ArrayList<>(questions.values());
    }

    public void showQuestions() {
        System.out.println("\n=== All Questions ===");
        for (Question q : questions.values()) {
            System.out.println(q.getTitle());
        }
    }


    private PostEntity findPostById(String id) {
        if (questions.containsKey(id))
            return questions.get(id);
        if (answers.containsKey(id))
            return answers.get(id);

        throw new NoSuchElementException("Post not found");
    }
}
