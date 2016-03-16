package com.github.brunodles.medicalconferences.repositories;

import android.support.annotation.NonNull;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Model;
import com.github.brunodles.medicalconferences.repositories.common.Callable;
import com.github.brunodles.medicalconferences.reposytory.Listener;
import com.github.brunodles.medicalconferences.reposytory.Repository;

/**
 * Created by bruno on 15/03/16.
 */
abstract class BaseRepository<Entity, DTO extends Model> implements Repository<Entity> {

    public BaseRepository() {
    }

    @Override
    public void create(Entity object, Listener listener) {
        tryWithConference(object, Model::save, listener);
    }

    @Override
    public void update(Entity object, Listener listener) {
        tryWithConference(object, Model::save, listener);
    }

    @Override
    public void delete(Entity object, Listener listener) {
        tryWithConference(object, Model::delete, listener);

    }

    private void tryWithConference(Entity obj, Callable<DTO> block, Listener listener) {
        ActiveAndroid.beginTransaction();
        DTO conference = parse(obj);
        try {
            block.run(conference);
            ActiveAndroid.setTransactionSuccessful();
            listener.onFinish(null);
        } catch (Exception e) {
            listener.onFinish(e);
        } finally {
            ActiveAndroid.endTransaction();
        }
    }

    @NonNull
    abstract DTO parse(Entity obj);
}
