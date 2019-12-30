package com.example.a1_khinyadanaraung;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeColor extends AppCompatActivity {

    Button btnRed,btnGreen,btnBlue,btnPurple;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changecolor);

        getSupportActionBar().setTitle("Setting");

        btnRed = (Button) findViewById(R.id.btnRed);
        btnGreen = (Button) findViewById(R.id.btnGreen);
        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnPurple = (Button) findViewById(R.id.btnPurple);

        preferences = getSharedPreferences("value",MODE_PRIVATE);
    }
    public void redBG(View view){
        preferences.edit().putInt("theme",2).apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void greenBG(View view){
        preferences.edit().putInt("theme",1).apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void blueBG(View view){
        preferences.edit().putInt("theme",3).apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void purpleBG(View view){
        preferences.edit().putInt("theme",4).apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
