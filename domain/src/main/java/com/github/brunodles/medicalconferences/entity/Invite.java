package com.github.brunodles.medicalconferences.entity;

/**
 * Created by bruno on 14/03/16.
 */
public class Invite {

    private final User user;
    private final Conference conference;
    private boolean accepted;

    public Invite(User user, Conference conference) {
        this.user = user;
        this.conference = conference;
    }

    public User getUser() {
        return user;
    }

    public Conference getConference() {
        return conference;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isAccepted() {
        return accepted;
    }
}
