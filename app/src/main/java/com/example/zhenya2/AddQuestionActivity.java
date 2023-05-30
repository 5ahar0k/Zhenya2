package com.example.zhenya2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddQuestionActivity extends AppCompatActivity {
    Button saveQuestion;
    EditText  text, themeId, points;
    DBQuestions dbQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        this.text = findViewById(R.id.text);
        this.points = findViewById(R.id.points);
        saveQuestion = findViewById(R.id.saveQuestion);
        saveQuestion.setOnClickListener((v) -> save());
        dbQuestions = new DBQuestions(getBaseContext());

    }

        private void save() {
            Intent i = getIntent();
            int id = i.getIntExtra("tId", 0);
            String textString = text.getText().toString();
            int pointsString = Integer.parseInt(points.getText().toString());
            Question question = new Question(textString, id, pointsString);
            dbQuestions.insert(question);
            finish();
    }
}