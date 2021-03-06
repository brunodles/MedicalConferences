package com.github.brunodles.medicalconferences.repositories;

import android.support.annotation.NonNull;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.repositories.dtos.ConferenceRecord;
import com.github.brunodles.medicalconferences.reposytory.Finder;

import java.util.List;

/**
 * Created by bruno on 15/03/16.
 */
public class ConferenceRepository extends BaseRepository<
        Conference, ConferenceRecord> {

    @NonNull
    @Override
    ConferenceRecord parse(Conference obj) {
        return new ConferenceRecord(obj);
    }
}
