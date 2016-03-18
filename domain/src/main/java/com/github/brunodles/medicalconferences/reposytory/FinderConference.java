package com.github.brunodles.medicalconferences.reposytory;

import com.github.brunodles.medicalconferences.entity.Conference;

import java.util.List;

/**
 * Created by bruno on 18/03/16.
 */
public interface FinderConference<ID> extends Finder<Conference, ID>{

    List<Conference> all_2() ;
}
