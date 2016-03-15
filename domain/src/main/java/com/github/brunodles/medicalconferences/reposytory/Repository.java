package com.github.brunodles.medicalconferences.reposytory;

/**
 * Created by bruno on 04/09/15.
 */
public interface Repository<T> {

    void create(T object, Listener listener);

    void update(T object, Listener listener);

    void delete(T object, Listener listener);
}
