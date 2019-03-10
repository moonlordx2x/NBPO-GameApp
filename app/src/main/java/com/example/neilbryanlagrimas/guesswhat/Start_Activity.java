package com.example.neilbryanlagrimas.guesswhat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Start_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_);
    }

    public void onStartBtn(View view) {
        startActivity(new Intent(Start_Activity.this,MainActivity.class));
    }

    public void onHighScore(View view) {
        startActivity(new Intent(Start_Activity.this,Sample.class));
    }
}
