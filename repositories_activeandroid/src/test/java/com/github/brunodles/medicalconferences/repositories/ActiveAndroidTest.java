package com.github.brunodles.medicalconferences.repositories;

import android.os.Build;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.github.brunodles.medicalconferences.TestApplication;
import com.github.brunodles.medicalconferences.repositories.dtos.Temp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

/**
 * Created by bruno on 16/03/16.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = Build.VERSION_CODES.JELLY_BEAN,
        application = TestApplication.class,
        constants = BuildConfig.class)
public class ActiveAndroidTest {

    @Table(name = "Categories")
    public static class Category extends Model {
        @Column(name = "Name")
        public String name;

        public Category(String name) {
            this.name = name;
        }
    }

    @Test
    public void shouldBeAbleToSaveInnerStaticClass() {
        Category category = new Category("Awesome");
        category.save();
        assertTrue(category.getId() > 0);
    }

    @Test
    public void shouldBeAbleToSave() {
//        Contact temp = new Contact();
        Temp temp = new Temp();
        temp.name = "Temp";
        temp.save();
        assertTrue(temp.getId() > 0);
    }


}
