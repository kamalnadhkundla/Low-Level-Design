package DesignStackOverFlow.Entity;

import DesignStackOverFlow.Types.*;

public class Event {
    User author;
   EventType EventType;
    VoteType voteType;
    Event(User author,EventType eventType,VoteType vote){
        this.author=author;
        this.EventType=eventType;
        this.voteType =vote;
    }
    public EventType getEventType(){return this.EventType;}
    public User getAuthor(){return this.author;}
     
}
