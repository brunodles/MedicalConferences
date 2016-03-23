package com.github.brunodles.medicalconferences.reposytory;


import com.github.brunodles.medicalconferences.entity.Entity;

/**
 * Created by bruno on 04/09/15.
 */
public interface Repository<T extends Entity> {

    void create(T object, Listener listener);

    void update(T object, Listener listener);

    void delete(T object, Listener listener);
}
