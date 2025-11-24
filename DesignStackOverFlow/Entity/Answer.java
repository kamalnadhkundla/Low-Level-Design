package DesignStackOverFlow.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import DesignStackOverFlow.Types.VoteType;

public class Answer extends QAEntity {
    private boolean isAccepted = false;
    private List<Vote> votes= new ArrayList<>();
    public int score=0;
private List<Comment> comments = new ArrayList<>();
    public Answer(String body, User author) {
        super(UUID.randomUUID().toString(), body, author);
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
    public void addComment(Comment e){
        this.comments.add(e);
    }

    public boolean isAccepted() { return isAccepted; }
      public void addVote(Vote vote){
        votes.add(vote);

        int tempScore = 0;
        for (Vote v : votes) {
            if (v.getVoteType() == VoteType.UPVOTE)
                tempScore++;
            else if (v.getVoteType() == VoteType.DOWNVOTE)
                tempScore--;
        }
        this.score = tempScore;

    
   }
   public int getScore(){
    return this.score;
   }
 

}