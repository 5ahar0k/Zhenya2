package com.example.zhenya2;

import static com.example.zhenya2.OpenHelper.THEMES_ID;
import static com.example.zhenya2.OpenHelper.THEMES_TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBThemes {
    private OpenHelper openHelper;
    private SQLiteDatabase db;

    public DBThemes(Context ctx) {
        openHelper = new OpenHelper(ctx);
        db = openHelper.getWritableDatabase();
    }

    public void insert(Theme theme) {
        ContentValues cv = new ContentValues();
        cv.put(OpenHelper.THEMES_NAME, theme.getName());
        //cv.put(OpenHelper.THEMES_ID, theme.getId());
        cv.put(OpenHelper.THEMES_STARTID, theme.getStartId());
        db.insert(THEMES_TABLE_NAME, null , cv);
    }
//    public void delete(int id) {
//        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
//    }
    public Theme select(int id) {
    Cursor cursor = db.query(THEMES_TABLE_NAME, null, THEMES_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);
        cursor.moveToFirst();
        Theme theme = new Theme(cursor.getInt(OpenHelper.THEMES_ID_NUM),
                cursor.getString(OpenHelper.THEMES_NAME_NUM),
                cursor.getInt(OpenHelper.THEMES_STARTID_NUM)
        );
        return  theme;
    }

    public ArrayList<Theme> getAll() {
        Cursor cursor = db.query(THEMES_TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Theme> themes = new ArrayList<>();
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                 Theme theme = new Theme(cursor.getInt(OpenHelper.THEMES_ID_NUM),
                        cursor.getString(OpenHelper.THEMES_NAME_NUM),
                        cursor.getInt(OpenHelper.THEMES_STARTID_NUM)
                );
                themes.add(theme);
            } while (cursor.moveToNext());
        }


        return themes;
    }

}

