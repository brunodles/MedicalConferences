package com.github.brunodles.medicalconferences.repositories.tables;

/**
 * Created by bruno on 15/03/16.
 */
public class ContactTable {

    public static final String TABLE = "contact";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";

    public static String getCreateTableQuery() {
        return "CREATE TABLE " + TABLE + "("
                + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY, "
                + COLUMN_NAME + " TEXT NOT NULL, "
                + COLUMN_EMAIL + " TEXT, "
                + COLUMN_PHONE + " TEXT"
                + ");";

    }
}
