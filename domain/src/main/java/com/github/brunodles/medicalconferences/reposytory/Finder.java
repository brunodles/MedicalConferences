package com.github.brunodles.medicalconferences.reposytory;

import java.util.List;

/**
 * Created by bruno on 14/03/16.
 */
public interface Finder<T, ID> {

    T get(ID id);

    Finder<T, ID> findBy(String key, Object object);

    List<T> list(int size);

    List<T> list();
}
