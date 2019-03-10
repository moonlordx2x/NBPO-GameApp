package com.example.neilbryanlagrimas.guesswhat;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Database>list;
    private List<Integer> random_array;

    private Button Button_1,Button_2,Button_3,Button_4;
    private ImageView imageView;
    private TextView textView,hp,timer;

    private Random r = new Random();
    private int total_score = 0,life = 3;
    private long time;

    private CountDownTimer countDownTimer;
    private Boolean aBoolean = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView5);
        textView = findViewById(R.id.Shuffle_word);
        timer = findViewById(R.id.Timer);
        hp = findViewById(R.id.life);

        Button_1 = findViewById(R.id.Button_1);
        Button_2 = findViewById(R.id.Button_2);
        Button_3 = findViewById(R.id.Button_3);
        Button_4 = findViewById(R.id.Button_4);

        Button_1.setOnClickListener(this);
        Button_2.setOnClickListener(this);
        Button_3.setOnClickListener(this);
        Button_4.setOnClickListener(this);

        start();
    }

    private void start(){
        list = new ArrayList<>();

        for (int i = 0; i < new Media().medias.length;i++){
            list.add(new Database(new Media().medias[i],new Media().media_logo[i]));
        }
        Question();
        Timer();
    }

    private void Timer() {
        time = 6000;

        if (aBoolean == false) {
            openDialog();
        } else {
            countDownTimer = new CountDownTimer(time, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    time = millisUntilFinished;
                    updatetimer();
                }

                @Override
                public void onFinish() {
                    time = 0;
                    updatetimer();
                }
            }.start();
        }
    }

    private void updatetimer(){
            int minutes = (int) (time / 1000) / 60 ;
            int seconds = (int) (time / 1000) % 60 ;

            String format = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

            timer.setText(format);
            if(seconds <=0){
                life = 0;
                Question();
                countDownTimer.cancel();
            }
    }

    private void Question() {

        if (total_score >= 10) {
            aBoolean = false;
            Timer();
        }
        else if (life <= 0) {
            Toast.makeText(MainActivity.this, "Game over", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, Start_Activity.class));
            finish();
        }
        else {
            Collections.shuffle(list);
            imageView.setImageResource(list.get(0).getMedia_logo());
            random_array = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                random_array.add(i);
            }
            Collections.shuffle(random_array);

            Button_1.setText(list.get(random_array.get(0)).getMedia());
            Button_2.setText(list.get(random_array.get(1)).getMedia());
            Button_3.setText(list.get(random_array.get(2)).getMedia());
            Button_4.setText(list.get(random_array.get(3)).getMedia());

            textView.setText("Total Score : " + total_score);
            hp.setText("HP : " + Integer.toString(life));
        }
    }

    private void openDialog(){
        Intent i = new Intent(this,Next_Page.class);
        i.putExtra("value",total_score);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View v) {

        if(v == Button_1){

            String answer = Button_1.getText().toString();
            if(answer == list.get(0).getMedia()){
                list.remove(0).getMedia_logo();
                total_score+=1;
            }else{
                life-=1;
            }
            Question();
            countDownTimer.cancel();
            Timer();
        }
        else if(v == Button_2){

            String answer = Button_2.getText().toString();
            if(answer == list.get(0).getMedia()){
                list.remove(0).getMedia_logo();
                total_score+=1;
            }else{
                life-=1;
            }
            Question();
            countDownTimer.cancel();
            Timer();
        }
        else if(v == Button_3){

            String answer = Button_3.getText().toString();
            if(answer == list.get(0).getMedia()){
                list.remove(0).getMedia_logo();
                total_score+=1;
            }else{
                life-=1;
            }
            Question();
            countDownTimer.cancel();
            Timer();
        }
        else if(v == Button_4){

            String answer = Button_4.getText().toString();
            if(answer == list.get(0).getMedia()){
                list.remove(0).getMedia_logo();
                total_score+=1;
            }else{
                life-=1;
            }
            Question();
            countDownTimer.cancel();
            Timer();
        }
    }
}
