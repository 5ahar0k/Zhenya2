package com.example.zhenya2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestActivity extends AppCompatActivity {
    LinearLayout buttons;
    TextView points,text,subject;
    Question question;
    Theme theme;
    History history;
    DBQuestions dbq;
    DBAnswers dba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        points = findViewById(R.id.k);
        text = this.findViewById(R.id.text);
        buttons = findViewById(R.id.buttons);
        Intent i = getIntent();
        int id = i.getIntExtra("tId",0);
        dbq = new DBQuestions(getBaseContext());
        question = dbq.getByTheme(id).get(0);
        history = new History("name", 0);
        show();
    }
    public void show(){
        text.setText(question.getText());
        history.setPoints(history.getPoints()+ question.getPoints());
        points.setText("" + history.getPoints());
        dba = new DBAnswers(getBaseContext());
        ArrayList<Answer> list = dba.getByQuestion(question.getId());
        int count = list.size();
        for (int i = 0; i < count; i++) {
            Button b = new Button(getBaseContext());
            int a = i;
            b.setText(list.get(i).getText());
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttons.removeAllViews();
                    question = dbq.select(list.get(a).getNextQuestionId());
                    show();
                }
            });
            buttons.addView(b);
        }
    }
}