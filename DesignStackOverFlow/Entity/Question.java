package DesignStackOverFlow.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import DesignStackOverFlow.Types.VoteType;

public class Question extends QAEntity {
    private String title;
   public int score =0;
    private List<Answer> answers = new ArrayList<>();
    private Set<Tag> tags = new HashSet();
    private Answer acceptedAnswer;
    public List<Comment> comments= new ArrayList<>();
  public List<Vote> votes= new ArrayList<>();
    public Question(String title,User Author) {
      super(UUID.randomUUID().toString(),title,Author);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

   public void addComment(Comment e){
    this.comments.add(e);
   }
   public void addVote(Vote vote){
    this.votes.add(vote);
    int tempscore =0;
    for(Vote v : votes)
         if(v.getVoteType()==VoteType.UPVOTE) score++;
    else tempscore --;

    this.score=tempscore;
   

    
   }
   public int getScore(){
    return this.score;
   }

    public void editQuestion(String title) {
       this.title =title;
    }
    public synchronized void acceptAnswer(Answer answer){
        if (this.acceptedAnswer != null)
            throw new RuntimeException("An answer has already been accepted!");

        if (!answers.contains(answer))
            throw new RuntimeException("This answer does not belong to this question!");

        this.acceptedAnswer = answer;
        answer.isAccepted();
      
             
    }
    public String getTitle() { return title; }
    public Set<Tag> getTags() { return tags; }
    public List<Answer> getAnswers() { return answers; }  
}
