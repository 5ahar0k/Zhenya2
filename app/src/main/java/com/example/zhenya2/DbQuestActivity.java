package com.example.zhenya2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DbQuestActivity extends AppCompatActivity {
    Button addTheme;
    ListView ThemeList;
    DBThemes dbThemes;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_quest);
        this.addTheme = findViewById(R.id.addTheme);
        this.ThemeList = findViewById(R.id.ThemeList);
        dbThemes = new DBThemes(getBaseContext());
        addTheme.setOnClickListener((v) -> {
            startActivity(new Intent(getBaseContext(), AddThemeActivity.class));
        });
        ArrayList<Theme> list = dbThemes.getAll();
        ArrayAdapter<Theme> adapter = new ArrayAdapter<Theme>(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                list        );
        ThemeList.setAdapter(adapter);

        ThemeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(DbQuestActivity.this, QuestionActivity.class);
                i.putExtra("tId", list.get(position).getId());
                startActivity(i);
            }
        });
    }
}