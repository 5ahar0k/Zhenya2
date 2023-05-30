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
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {
    DBThemes db;
    TextView ThemeName;
    Button addQuestion, startQuest;
    ListView questionList;
    DBQuestions dbQuestions;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        questionList = findViewById(R.id.questionList);
        Intent i = getIntent();
        int id = i.getIntExtra("tId", 0);
        db = new DBThemes(getBaseContext());
        Theme theme = db.select(id);
        dbQuestions = new DBQuestions(getBaseContext());
        ArrayList<Question> list = dbQuestions.getByTheme(id);
        ArrayAdapter<Question> adapter = new ArrayAdapter<Question>(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                list);
        questionList.setAdapter(adapter);
        this.ThemeName = findViewById(R.id.ThemeName);
        ThemeName.setText(theme.getName());
        startQuest = findViewById(R.id.startQuest);
        startQuest.setOnClickListener((v) -> {
            Intent i2 = new Intent(QuestionActivity.this, QuestActivity.class);
            i2.putExtra("tId", id);
            startActivity(i2);
        });
        addQuestion = findViewById(R.id.addQuestion);
        addQuestion.setOnClickListener((v) -> {
            Intent i2 = new Intent(QuestionActivity.this, AddQuestionActivity.class);
            i2.putExtra("tId", id);
            startActivity(i2);
        });

        questionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(QuestionActivity.this, AnswerActivity.class);
                i.putExtra("qId", list.get(position).getId());
                startActivity(i);
            }
        });
    }
}