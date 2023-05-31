package com.example.zhenya2;

import static com.example.zhenya2.OpenHelper.QUESTIONS_ID;
import static com.example.zhenya2.OpenHelper.QUESTIONS_POINTS;
import static com.example.zhenya2.OpenHelper.QUESTIONS_TABLE_NAME;
import static com.example.zhenya2.OpenHelper.QUESTIONS_TEXT;
import static com.example.zhenya2.OpenHelper.QUESTIONS_THEMEID;
import static com.example.zhenya2.OpenHelper.THEMES_ID;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBQuestions {
    private OpenHelper openHelper;
    private SQLiteDatabase db2;

    public DBQuestions(Context ctx) {
        openHelper = new OpenHelper(ctx);
        db2 = openHelper.getWritableDatabase();
    }

    public void insert(Question question) {
        ContentValues cv = new ContentValues();
        ContentValues cv2 = new ContentValues();
        cv.put(OpenHelper.QUESTIONS_TEXT, question.getText());
        cv.put(QUESTIONS_POINTS, question.getPoints());
        cv2.put(QUESTIONS_POINTS, 10);
        cv.put(QUESTIONS_THEMEID, question.getThemeId());

    }
    public Question select(int id) {
        Cursor cursor = db2.query(QUESTIONS_TABLE_NAME, null, QUESTIONS_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);
        cursor.moveToFirst();
        Question question = new Question(cursor.getInt(OpenHelper.QUESTIONS_ID_NUM),
                cursor.getString(OpenHelper.QUESTIONS_NAME_NUM),
                cursor.getInt(OpenHelper.QUESTIONS_THEMEID_NUM),
                cursor.getInt(OpenHelper.QUESTIONS_POINTS_NUM)
        );
        return  question;
    }

    public ArrayList<Question> getByTheme(int id) {
        Cursor cursor = db2.query(QUESTIONS_TABLE_NAME, null, QUESTIONS_THEMEID + " = ?", new String[]{String.valueOf(id)}, null, null, null);
        cursor.moveToFirst();
        ArrayList<Question> questions = new ArrayList<>();
        if (!cursor.isAfterLast()) {
            do {
                Question question = new Question(cursor.getInt(OpenHelper.QUESTIONS_ID_NUM),
                        cursor.getString(OpenHelper.QUESTIONS_NAME_NUM),
                        cursor.getInt(OpenHelper.QUESTIONS_THEMEID_NUM),
                        cursor.getInt(OpenHelper.QUESTIONS_POINTS_NUM)
                );
                questions.add(question);
            } while (cursor.moveToNext());
        }
        return questions;
    }
}


