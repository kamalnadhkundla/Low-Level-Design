package DesignStackOverFlow.Observer;

import DesignStackOverFlow.Entity.Event;

public class reputationManager implements PostObserver {

    public static final int UPVOTE_QUESTION = 2;
    public static final int DOWNVOTE_QUESTION = -2;
    public static final int UPVOTE_ANSWER = 2;
    public static final int DOWNVOTE_ANSWER = -2;
    public static final int ACCEPTED_ANSWER = 5;

    @Override
    public void onPostEvent(Event e) {

        switch (e.getEventType()) {

            case UPVOTE_ANSWER:
                e.getAuthor().updateReputation(UPVOTE_ANSWER);
                break;

            case DOWNVOTE_ANSWER:
                e.getAuthor().updateReputation(DOWNVOTE_ANSWER);
                break;

            case UPVOTE_QUESTION:
                e.getAuthor().updateReputation(UPVOTE_QUESTION);
                break;

            case DOWNVOTE_QUESTION:
                e.getAuthor().updateReputation(DOWNVOTE_QUESTION);
                break;

            case ACCEPTED_ANSWER:
                e.getAuthor().updateReputation(ACCEPTED_ANSWER);
                break;

            default:
                // no change in reputation
                break;
        }
    }
}
