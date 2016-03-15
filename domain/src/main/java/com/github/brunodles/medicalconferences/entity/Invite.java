package com.github.brunodles.medicalconferences.entity;

/**
 * Created by bruno on 14/03/16.
 */
public class Invite {

    private final User user;
    private final Conference conference;
    private State state;

    public Invite(User user, Conference conference) {
        this.user = user;
        this.conference = conference;
        state = State.NONE;
    }

    public User getUser() {
        return user;
    }

    public Conference getConference() {
        return conference;
    }

    public void setAccepted() {
        state = State.ACCEPTED;
    }

    public void setRejected(){
        state = State.REJECTED;
    }

    public boolean isAccepted() {
        return state == State.ACCEPTED;
    }

    public boolean isRejected() {
        return state == State.REJECTED;
    }

    private static enum State{
        NONE, ACCEPTED, REJECTED;
    }
}
