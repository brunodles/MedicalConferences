package com.github.brunodles.medicalconferences.repositories;

import android.support.annotation.NonNull;

import com.github.brunodles.medicalconferences.entity.Conference;

/**
 * Created by bruno on 15/03/16.
 */
public class ConferenceRepository extends BaseRepository<
        Conference, com.github.brunodles.medicalconferences.repositories.dtos.Conference> {

    @NonNull
    @Override
    com.github.brunodles.medicalconferences.repositories.dtos.Conference parse(Conference obj) {
        return new com.github.brunodles.medicalconferences.repositories.dtos.Conference(obj);
    }
}
