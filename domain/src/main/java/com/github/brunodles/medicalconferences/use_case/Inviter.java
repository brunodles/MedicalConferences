package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.entity.Invite;
import com.github.brunodles.medicalconferences.entity.User;
import com.github.brunodles.medicalconferences.entity_impl.InviteImpl;
import com.github.brunodles.medicalconferences.reposytory.Finder;
import com.github.brunodles.medicalconferences.reposytory.Listener;
import com.github.brunodles.medicalconferences.reposytory.LogErrorListener;
import com.github.brunodles.medicalconferences.reposytory.Repository;

import java.util.List;

/**
 * Created by bruno on 14/03/16.
 */
public class Inviter {

    private Repository<Invite> inviteRepository;
    private Finder<Invite, Long> inviteFinder;
    private Listener createListener = LogErrorListener.get();
    private Listener updateListener = LogErrorListener.get();

    public Inviter(Repository<Invite> inviteRepository, Finder<Invite, Long> inviteFinder) {
        this.inviteRepository = inviteRepository;
        this.inviteFinder = inviteFinder;
    }

    public boolean invite(User user, Conference conference) {
        if (user == null) return false;
        if (conference == null) return false;
        Invite invite = new InviteImpl(user, conference);
        inviteRepository.create(invite, createListener);
        return true;
    }

    public List<Invite> listInvitesTo(User user, int size) {
        return inviteFinder.findBy("user", user).list(size);
    }


    public Invite accept(Invite invite) {
        InviteImpl i = new InviteImpl(invite);
        i.setAccepted();
        inviteRepository.update(i, updateListener);
        return i;
    }

    public Invite reject(Invite invite) {
        InviteImpl i = new InviteImpl(invite);
        i.setRejected();
        inviteRepository.update(i, updateListener);
        return i;
    }

    public void setCreateListener(Listener createListener) {
        this.createListener = createListener;
    }

    public void setUpdateListener(Listener updateListener) {
        this.updateListener = updateListener;
    }
}
