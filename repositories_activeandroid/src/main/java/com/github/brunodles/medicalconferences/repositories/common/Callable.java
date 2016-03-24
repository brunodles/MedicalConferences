package com.github.brunodles.medicalconferences.repositories.common;

/**
 * Created by bruno on 15/03/16.
 */
public interface Callable<T> {
    void run(T param);
}
