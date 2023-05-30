package com.example.zhenya2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AnswerActivity extends AppCompatActivity {
TextView QuestionName;
Button addAnswer;
DBAnswers dbAnswers;
ListView answersList;
DBQuestions db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Intent i = getIntent();
        int id = i.getIntExtra("qId", 0);
        answersList = findViewById(R.id.answerList);
        addAnswer = findViewById(R.id.addAnswer);
        QuestionName = findViewById(R.id.QuestionText);
        db = new DBQuestions(getBaseContext());
        Question question = db.select(id);
        QuestionName.setText(question.getText());
        dbAnswers = new DBAnswers(getBaseContext());
        ArrayList<Answer> list = dbAnswers.getByQuestion(id);
        ArrayAdapter<Answer> adapter = new ArrayAdapter<Answer>
                (getBaseContext(), android.R.layout.simple_list_item_1, list);
        answersList.setAdapter(adapter);
        addAnswer.setOnClickListener((v) -> {
            Intent i2 = new Intent(AnswerActivity.this, AddAnswerActivity.class);
            i2.putExtra("qId", id);
            startActivity(i2);
        });
    }
}