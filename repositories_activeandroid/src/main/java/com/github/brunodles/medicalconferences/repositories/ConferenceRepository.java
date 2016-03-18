package com.github.brunodles.medicalconferences.repositories;

import android.support.annotation.NonNull;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.reposytory.Finder;
import com.github.brunodles.medicalconferences.reposytory.FinderConference;

import java.util.List;

/**
 * Created by bruno on 15/03/16.
 */
public class ConferenceRepository extends BaseRepository<
        Conference, com.github.brunodles.medicalconferences.repositories.dtos.Conference>
        implements FinderConference<Long> {

    @NonNull
    @Override
    com.github.brunodles.medicalconferences.repositories.dtos.Conference parse(Conference obj) {
        return new com.github.brunodles.medicalconferences.repositories.dtos.Conference(obj);
    }

    @Override
    public Conference get(Long aLong) {
        return null;
    }

    @Override
    public Finder<Conference, Long> findBy(String key, Object object) {
        return null;
    }

    @Override
    public List<Conference> list(int size) {
        return null;
    }

    @Override
    public List<Conference> list() {
        return null;
    }

    @Override
    public List<Conference> all_2() {
        return null;
    }
}
