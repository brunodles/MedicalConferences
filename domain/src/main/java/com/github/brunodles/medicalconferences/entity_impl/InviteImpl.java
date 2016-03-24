package com.github.brunodles.medicalconferences.entity_impl;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.entity.Invite;
import com.github.brunodles.medicalconferences.entity.User;

import java.util.HashMap;

/**
 * Created by bruno on 14/03/16.
 */
public class InviteImpl implements Invite {

    private static final HashMap<String, State> stateMap;

    static {
        HashMap<String, State> m = new HashMap<>();
        m.put("falsefalse", State.NONE);
        m.put("truetrue", State.NONE);
        m.put("truefalse", State.ACCEPTED);
        m.put("falsetrue", State.REJECTED);
        stateMap = m;
    }

    private final User user;
    private final Conference conference;
    private Long id;
    private State state;

    public InviteImpl(User user, Conference conference) {
        this.user = user;
        this.conference = conference;
        state = State.NONE;
    }

    public InviteImpl(Invite invite) {
        this.user = invite.getUser();
        this.conference = invite.getConference();
        this.id = invite.getId();
        state = stateMap.get(String.format("%b%b", invite.isAccepted(), invite.isRejected()));
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public Conference getConference() {
        return conference;
    }

    public void setAccepted() {
        state = State.ACCEPTED;
    }

    public void setRejected() {
        state = State.REJECTED;
    }

    @Override
    public boolean isAccepted() {
        return state == State.ACCEPTED;
    }

    @Override
    public boolean isRejected() {
        return state == State.REJECTED;
    }

    @Override
    public Long getId() {
        return id;
    }

    private static enum State {
        NONE, ACCEPTED, REJECTED;
    }
}
