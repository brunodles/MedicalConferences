package com.github.brunodles.medicalconferences.reposytory;

import com.github.brunodles.medicalconferences.entity.Entity;

/**
 * Created by bruno on 23/03/16.
 */
interface EntityFinder<T extends Entity> extends Finder<T, Long> {
}
