package com.github.brunodles.medicalconferences.common;

/**
 * Created by bruno on 14/03/16.
 */
public interface Validator<T> {
    boolean isValid(T t);
}
