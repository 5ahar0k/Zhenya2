package com.example.zhenya2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddThemeActivity extends AppCompatActivity {
    Button saveTheme;
    EditText id, name, startid;
    DBThemes dbThemes;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_theme);
        this.saveTheme = findViewById(R.id.saveTheme);
        this.id = findViewById(R.id.id);
        this.name = findViewById(R.id.name);
        this.startid = findViewById(R.id.startid);
        saveTheme.setOnClickListener((v) -> save());
        dbThemes = new DBThemes(getBaseContext());
    }

    private void save() {
        String nameString = name.getText().toString();
        Theme theme = new Theme(nameString);

        dbThemes.insert(theme);
        finish();
    }
}