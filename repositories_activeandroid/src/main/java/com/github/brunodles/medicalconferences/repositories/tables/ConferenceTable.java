package com.github.brunodles.medicalconferences.repositories.tables;

/**
 * Created by bruno on 15/03/16.
 */
public class ConferenceTable {

    public static final String TABLE = "conference";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATE = "startDate";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ABSTRACT = "abstract";
    public static final String COLUMN_CANCELED = "canceled";
    public static final String COLUMN_CONTACT = "contact_id";
    public static final String COLUMN_LOCATION = "location";

    public static String getCreateTableQuery() {
        return "CREATE TABLE " + TABLE + "("
                + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY, "
                + COLUMN_DATE + " INTEGER NOT NULL, "
                + COLUMN_NAME + " TEXT NOT NULL, "
                + COLUMN_ABSTRACT + " TEXT NOT NULL, "
                + COLUMN_LOCATION + " TEXT NOT NULL, "
                + COLUMN_CONTACT + " INTEGER NOT NULL, "
                + COLUMN_CANCELED + " INTEGER NOT NULL"
                + ");";

    }
}
