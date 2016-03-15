package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.reposytory.Finder;
import com.github.brunodles.medicalconferences.reposytory.Listener;
import com.github.brunodles.medicalconferences.reposytory.LogErrorListener;
import com.github.brunodles.medicalconferences.reposytory.Repository;
import com.github.brunodles.medicalconferences.validator.ConferenceValidator;

public class Scheduler {

    private final ConferenceValidator conferenceValidator;
    private Repository<Conference> repository;
    private Finder<Conference, Long> finder;
    private Listener createListener = LogErrorListener.get();
    private Listener updateListener = LogErrorListener.get();

    public Scheduler(Repository<Conference> repository, Finder<Conference, Long> finder) {
        this.repository = repository;
        this.finder = finder;
        conferenceValidator = new ConferenceValidator();
    }

    public boolean add(Conference conference) {
        if (!conferenceValidator.isValid(conference)) return false;
        repository.create(conference, createListener);
        return true;
    }

    public Conference get(Long i) {
        return finder.get(i);
    }

    public boolean cancel(Conference conference) {
        conference.setCanceled(true);
        repository.update(conference, updateListener);
        return true;
    }

    public boolean cancel(long id) {
        Conference conference = finder.get(id);
        if (conference == null) return false;
        return cancel(conference);
    }

    public boolean edit(Conference conference) {
        if (!conferenceValidator.isValid(conference)) return false;
        repository.update(conference, updateListener);
        return true;
    }

    public void setCreateListener(Listener createListener) {
        this.createListener = createListener;
    }

    public void setUpdateListener(Listener updateListener) {
        this.updateListener = updateListener;
    }
}
