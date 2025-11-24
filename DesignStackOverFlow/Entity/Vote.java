package DesignStackOverFlow.Entity;

import DesignStackOverFlow.Types.VoteType;   // <-- correct import
import DesignStackOverFlow.Entity.User;      // <-- import User class

public class Vote {

    private User author;
    private VoteType voteType;

    public Vote(User author, VoteType voteType) {
        this.author = author;
        this.voteType = voteType;
    }

    public User getAuthor() {
        return author;
    }

    public VoteType getVoteType() {
        return voteType;
    }
}
