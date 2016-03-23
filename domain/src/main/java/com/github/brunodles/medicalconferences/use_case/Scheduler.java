package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.entity_impl.ConferenceImpl;
import com.github.brunodles.medicalconferences.reposytory.ConferenceFinder;
import com.github.brunodles.medicalconferences.reposytory.ConferenceRepository;
import com.github.brunodles.medicalconferences.reposytory.Listener;
import com.github.brunodles.medicalconferences.reposytory.LogErrorListener;
import com.github.brunodles.medicalconferences.validator.ConferenceValidator;

public class Scheduler {

    private final ConferenceValidator conferenceValidator;
    private ConferenceRepository repository;
    private ConferenceFinder finder;
    private Listener createListener = LogErrorListener.get();
    private Listener updateListener = LogErrorListener.get();

    public Scheduler(ConferenceRepository repository, ConferenceFinder finder) {
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

    public Conference cancel(Conference conference) {
        ConferenceImpl c = new ConferenceImpl(conference);
        c.setCanceled(true);
        repository.update(c, updateListener);
        return c;
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
