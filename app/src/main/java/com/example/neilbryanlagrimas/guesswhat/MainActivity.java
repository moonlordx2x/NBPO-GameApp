package com.example.neilbryanlagrimas.guesswhat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;
    int number;
     Button btn;
     TextView textView;
     List<Database>list;
     List<Integer> random_array;
     Random r = new Random();

     Button Button_1,Button_2,Button_3,Button_4;
     int total_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView5);
        btn = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.Shuffle_word);

        Button_1 = (Button)findViewById(R.id.Button_1);
        Button_2 = (Button)findViewById(R.id.Button_2);
        Button_3 = (Button)findViewById(R.id.Button_3);
        Button_4 = (Button)findViewById(R.id.Button_4);

        btn.setOnClickListener(this);
        Button_1.setOnClickListener(this);
        Button_2.setOnClickListener(this);
        Button_3.setOnClickListener(this);
        Button_4.setOnClickListener(this);

        start();
    }

    private void start(){
        btn.setVisibility(View.VISIBLE);
        Button_1.setVisibility(View.GONE);
        Button_2.setVisibility(View.GONE);
        Button_3.setVisibility(View.GONE);
        Button_4.setVisibility(View.GONE);
        total_score = 0;
        imageView.setImageResource(R.drawable.logo);
    }

    @Override
    public void onClick(View v) {

        if(v == btn){
            Question(0);
            btn.setVisibility(View.GONE);
            Button_1.setVisibility(View.VISIBLE);
            Button_2.setVisibility(View.VISIBLE);
            Button_3.setVisibility(View.VISIBLE);
            Button_4.setVisibility(View.VISIBLE);
        }
        else if(v == Button_1){

            String answer = Button_1.getText().toString();

            if(answer == list.get(0).getMedia()){
                Toast.makeText(this,"The Answer is Correct",Toast.LENGTH_SHORT).show();
                list.remove(0).getMedia();
                list.remove(0).getMedia_logo();
                total_score+=1;
                Question(1);
            }else{
                Toast.makeText(this,"The Answer is Wrong",Toast.LENGTH_SHORT).show();
                start();
            }
        }
        else if(v == Button_2){

            String answer = Button_2.getText().toString();

            if(answer == list.get(0).getMedia()){
                Toast.makeText(this,"The Answer is Correct",Toast.LENGTH_SHORT).show();
                list.remove(0).getMedia();
                list.remove(0).getMedia_logo();
                total_score+=1;
                Question(1);
            }else{
                Toast.makeText(this,"The Answer is Wrong",Toast.LENGTH_SHORT).show();
                start();
            }
        }
        else if(v == Button_3){

            String answer = Button_3.getText().toString();

            if(answer == list.get(0).getMedia()){
                Toast.makeText(this,"The Answer is Correct",Toast.LENGTH_SHORT).show();
                list.remove(0).getMedia();
                list.remove(0).getMedia_logo();
                total_score+=1;
                Question(1);
            }else{
                Toast.makeText(this,"The Answer is Wrong",Toast.LENGTH_SHORT).show();
                start();
            }
        }
        else if(v == Button_4){

            String answer = Button_4.getText().toString();

            if(answer == list.get(0).getMedia()){
                Toast.makeText(this,"The Answer is Correct",Toast.LENGTH_SHORT).show();
                list.remove(0).getMedia();
                list.remove(0).getMedia_logo();
                total_score+=1;
                Question(1);
            }else{
                Toast.makeText(this,"The Answer is Wrong",Toast.LENGTH_SHORT).show();
                start();
            }
        }
    }

    private void Question(int total){

        list = new ArrayList<>();

        for (int i = 0; i < new Media().medias.length;i++){
            list.add(new Database(new Media().medias[i],new Media().media_logo[i]));
        }

        Collections.shuffle(list);

        imageView.setImageResource(list.get(0).getMedia_logo());
        random_array = new ArrayList<>();

        for (int i = 0;i < 4;i++){
            random_array.add(i);
        }

        Collections.shuffle(random_array);

        Button_1.setText(list.get(random_array.get(0)).getMedia());
        Button_2.setText(list.get(random_array.get(1)).getMedia());
        Button_3.setText(list.get(random_array.get(2)).getMedia());
        Button_4.setText(list.get(random_array.get(3)).getMedia());

        String num = list.get(0).getMedia().toString();
        List<String> al = new ArrayList<String>(Arrays.asList(num.split("")));
        al.remove(0);
        Collections.shuffle(al);


        textView.setText("Output : "+al);

        LinearLayout buttonContainer = (LinearLayout) findViewById(R.id.button_container);
        Button button = new Button(MainActivity.this);
        /*
        for (int i=0;i < 2;i++){

            button.setText(al.get(i).toString());
            buttonContainer.addView(button);

        }
        */

        button.setText(al.get(1).toString());
        buttonContainer.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Next_Page.class));
            }
        });
    }
}
