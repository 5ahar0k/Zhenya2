package com.example.zhenya2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class AddAnswerActivity extends AppCompatActivity {
    TextView qText;
    DBQuestions dbq;
    DBAnswers dba;
    EditText text;
    Spinner spinner;
    Question next;
    Button saveAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_answer);
        qText = findViewById(R.id.qText);
        Intent i = getIntent();
        int id = i.getIntExtra("qId", 0);
        dbq = new DBQuestions(getBaseContext());
        dba = new DBAnswers(getBaseContext());
        saveAnswer = findViewById(R.id.saveAnswer);
        Question question = dbq.select(id);
        qText.setText(question.getText());
        text = findViewById(R.id.text);
        spinner = findViewById(R.id.spinner);
        ArrayList<Question> list = dbq.getByTheme(question.getThemeId());
        ArrayAdapter<Question> adapter = new ArrayAdapter<Question>(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                list);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                next = list.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        saveAnswer.setOnClickListener(v -> save());
    }

    private void save() {
        Intent i = getIntent();
        int id = i.getIntExtra("qId", 0);
        String textString = text.getText().toString();
        Answer answer = new Answer(textString, id, next.getId());
        dba.insert(answer);
        finish();
    }
}