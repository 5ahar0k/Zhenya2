package com.example.zhenya2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OpenHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "quest.db";
    public static final int DB_VERSIONS = 7;
    
    public static final String THEMES_TABLE_NAME = "themes";
    public static final String THEMES_ID = "id";
    public static final int THEMES_ID_NUM = 0;
    public static final String THEMES_NAME = "name";
    public static final int THEMES_NAME_NUM = 1;
    public static final String THEMES_STARTID = "startid";
    public static final int THEMES_STARTID_NUM = 2;

    public static final String QUESTIONS_TABLE_NAME = "question";
    public static final String QUESTIONS_ID = "id";
    public static final int QUESTIONS_ID_NUM = 0;
    public static final String QUESTIONS_TEXT = "text";
    public static final int QUESTIONS_NAME_NUM = 1;
    public static final String QUESTIONS_THEMEID = "themeid";
    public static final int QUESTIONS_THEMEID_NUM = 2;
    public static final String QUESTIONS_POINTS = "points";
    public static final int QUESTIONS_POINTS_NUM = 3;

    public static final String ANSWERS_TABLE_NAME = "answers";
    public static final String ANSWERS_ID = "id";
    public static final int ANSWERS_ID_NUM = 0;
    public static final String ANSWERS_TEXT = "text";
    public static final int ANSWERS_TEXT_NUM = 1;
    public static final String ANSWERS_QUESTIONID = "questionid";
    public static final int ANSWERS_QUESTIONID_NUM = 2;
    public static final String ANSWERS_NEXTQUESTIONID = "nextquestionid";
    public static final int ANSWERS_NEXTQUESTIONID_NUM = 3;


    public OpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSIONS);
    }

    @Override    public void onCreate(SQLiteDatabase db) {
        createPointsTable(db);
        createQuestionsTable(db);
        createAnswersTable(db);
    }

    private void createPointsTable(SQLiteDatabase db) {
        String query = "create table " + THEMES_TABLE_NAME + "(" +
                THEMES_ID +" integer primary key autoincrement," +
                THEMES_NAME + " TEXT," +
                THEMES_STARTID+ " INTEGER" +
                ")";
        db.execSQL(query);
    }
    private void createQuestionsTable(SQLiteDatabase db) {
        String query = "create table " + QUESTIONS_TABLE_NAME + "(" +
                QUESTIONS_ID +" integer primary key autoincrement," +
                QUESTIONS_TEXT + " TEXT," +
                QUESTIONS_THEMEID + " INTEGER," +
                QUESTIONS_POINTS + " INTEGER" +
                ")";
        db.execSQL(query);
    }
    private void createAnswersTable(SQLiteDatabase db) {
        String query = "create table " + ANSWERS_TABLE_NAME + "(" +
                ANSWERS_ID +" integer primary key autoincrement," +
                ANSWERS_TEXT + " TEXT," +
                ANSWERS_QUESTIONID + " INTEGER," +
                ANSWERS_NEXTQUESTIONID + " INTEGER" +
                ")";
        db.execSQL(query);
    }
    
    @Override    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + THEMES_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QUESTIONS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ANSWERS_TABLE_NAME);
        onCreate(db);

    }
}
