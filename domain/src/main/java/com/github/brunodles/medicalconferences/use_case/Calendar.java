package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.reposytory.ConferenceFinder;

import java.util.Date;
import java.util.List;

/**
 * Created by bruno on 15/03/16.
 */
public class Calendar {

    ConferenceFinder conferenceFinder;

    public Calendar(ConferenceFinder conferenceFinder) {
        this.conferenceFinder = conferenceFinder;
    }

    public List<Conference> listNextConferences() {
        return conferenceFinder.findBy("startDate", new Date()).list();
    }
}
