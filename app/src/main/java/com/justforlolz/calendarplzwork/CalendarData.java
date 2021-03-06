package com.justforlolz.calendarplzwork;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nathan on 1/13/15.
 */
public abstract class CalendarData extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DICTIONARY_TABLE_NAME = "dictionary";
    //private static final String DICTIONARY_TABLE_CREATE = "CREATE TABLE " + DICTIONARY_TABLE_NAME + " (" + KEY_WORD + " TEXT, " + KEY_DEFINITION + " TEXT);";

    CalendarData(Context context) {
        super(context, "DATABASE_NAME", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DICTIONARY_TABLE_CREATE");
    }
}
