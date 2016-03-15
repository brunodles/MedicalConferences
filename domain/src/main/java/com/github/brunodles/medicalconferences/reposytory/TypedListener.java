package com.github.brunodles.medicalconferences.reposytory;

/**
 * Created by bruno on 04/09/15.
 */
public interface TypedListener<T> {
    void onError(Exception exception);

    void onSuccess(T result);
}
