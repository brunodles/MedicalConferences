package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.reposytory.Finder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bruno on 15/03/16.
 */
public class Calendar {

    Finder<Conference, Long> conferenceFinder;

    public Calendar(Finder<Conference, Long> conferenceFinder) {
        this.conferenceFinder = conferenceFinder;
    }

    public List<Conference> listNextConferences() {
        return conferenceFinder.findBy("startDate", new Date()).list();
    }
}
