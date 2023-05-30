package com.example.zhenya2;

import static com.example.zhenya2.OpenHelper.ANSWERS_NEXTQUESTIONID;
import static com.example.zhenya2.OpenHelper.ANSWERS_QUESTIONID;
import static com.example.zhenya2.OpenHelper.ANSWERS_TABLE_NAME;
import static com.example.zhenya2.OpenHelper.QUESTIONS_ID;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBAnswers {
    private OpenHelper openHelper;
    private SQLiteDatabase db;

    public DBAnswers(Context ctx) {
        openHelper = new OpenHelper(ctx);
        db = openHelper.getWritableDatabase();
    }
    public void insert(Answer answer) {
        ContentValues cv = new ContentValues();
        cv.put(OpenHelper.ANSWERS_TEXT, answer.getText());
        cv.put(ANSWERS_QUESTIONID, answer.getQuestionId());
        cv.put(ANSWERS_NEXTQUESTIONID, answer.getNextQuestionId());
        db.insert(ANSWERS_TABLE_NAME, null , cv);
    }
    public ArrayList<Answer> getByQuestion(int id) {
        Cursor cursor = db.query(ANSWERS_TABLE_NAME, null, ANSWERS_QUESTIONID + " = ?", new String[]{String.valueOf(id)}, null, null, null);
        cursor.moveToFirst();
        ArrayList<Answer> answers = new ArrayList<>();
        if (!cursor.isAfterLast()) {
            do {
                Answer answer = new Answer(cursor.getInt(OpenHelper.ANSWERS_ID_NUM),
                        cursor.getString(OpenHelper.ANSWERS_TEXT_NUM),
                        cursor.getInt(OpenHelper.ANSWERS_QUESTIONID_NUM),
                        cursor.getInt(OpenHelper.ANSWERS_NEXTQUESTIONID_NUM)
                );
                answers.add(answer);
            } while (cursor.moveToNext());
        }
        return answers;
    }
    public ArrayList<Answer> getAll() {
        Cursor cursor = db.query(ANSWERS_TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Answer> answers = new ArrayList<>();
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                Answer answer = new Answer(cursor.getInt(OpenHelper.ANSWERS_ID_NUM),
                        cursor.getString(OpenHelper.ANSWERS_TEXT_NUM),
                        cursor.getInt(OpenHelper.ANSWERS_QUESTIONID_NUM),
                        cursor.getInt(OpenHelper.ANSWERS_NEXTQUESTIONID_NUM)
                );
                answers.add(answer);
            } while (cursor.moveToNext());
        }


        return answers;
    }
}
