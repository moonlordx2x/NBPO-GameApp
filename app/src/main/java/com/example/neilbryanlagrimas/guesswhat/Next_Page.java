package com.example.neilbryanlagrimas.guesswhat;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Next_Page extends AppCompatActivity implements View.OnClickListener{

    private Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_10,btn_11,btn_12;
    private TextView editText,Text_checker;
    private ImageView Images_guess;
    List<Database> list;
    List<String> quest_letters;
    String textanswer;
    String text;
    String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next__page);

        Images_guess = (ImageView)findViewById(R.id.Images_guess);
        editText = (TextView) findViewById(R.id.output_text);
        Text_checker = (TextView) findViewById(R.id.Text_checker);

        btn_1 = (Button)findViewById(R.id.quess_button1);
        btn_2 = (Button)findViewById(R.id.quess_button2);
        btn_3 = (Button)findViewById(R.id.quess_button3);
        btn_4 = (Button)findViewById(R.id.quess_button4);
        btn_5 = (Button)findViewById(R.id.quess_button5);
        btn_6 = (Button)findViewById(R.id.quess_button6);
        btn_7 = (Button)findViewById(R.id.quess_button7);
        btn_8 = (Button)findViewById(R.id.quess_button8);
        btn_9 = (Button)findViewById(R.id.quess_button9);
        btn_10 = (Button)findViewById(R.id.quess_button10);
        btn_11 = (Button)findViewById(R.id.quess_button11);
        btn_12 = (Button)findViewById(R.id.quess_button12);

        question_generate();

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_10.setOnClickListener(this);
        btn_11.setOnClickListener(this);
        btn_12.setOnClickListener(this);

        editText.setOnClickListener(this);

        if(editText.getText().toString().equals(textanswer)){
            Toast.makeText(this,"The Answer is Correct "+textanswer,Toast.LENGTH_SHORT).show();
            editText.setText("");
            question_generate();
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.quess_button1:
                check_answer();
                text = btn_1.getText().toString();
                editText.setText(editText.getText().toString()+text);
                btn_1.setEnabled(false);
                break;

            case R.id.quess_button2:
                check_answer();
                text = btn_2.getText().toString();
                editText.setText(editText.getText().toString()+text);
                btn_2.setEnabled(false);
                break;

            case R.id.quess_button3:
                check_answer();
                text = btn_3.getText().toString();
                editText.setText(editText.getText().toString()+text);
                btn_3.setEnabled(false);
                break;

            case R.id.quess_button4:
                check_answer();
                text = btn_4.getText().toString();
                editText.setText(editText.getText().toString()+text);
                btn_4.setEnabled(false);
                break;

            case R.id.quess_button5:
                check_answer();
                text = btn_5.getText().toString();
                editText.setText(editText.getText().toString()+text);
                btn_5.setEnabled(false);
                break;

            case R.id.quess_button6:
                check_answer();
                text = btn_6.getText().toString();
                editText.setText(editText.getText().toString()+text);
                btn_6.setEnabled(false);
                break;

            case R.id.quess_button7:
                check_answer();
                text = btn_7.getText().toString();
                editText.setText(editText.getText().toString()+text);
                btn_7.setEnabled(false);
                break;

            case R.id.quess_button8:
                check_answer();
                text = btn_8.getText().toString();
                editText.setText(editText.getText().toString()+text);
                btn_8.setEnabled(false);
                break;

            case R.id.quess_button9:
                check_answer();
                text = btn_9.getText().toString();
                editText.setText(editText.getText().toString()+text);
                btn_9.setEnabled(false);
                break;

            case R.id.quess_button10:
                check_answer();
                text = btn_10.getText().toString();
                editText.setText(editText.getText().toString()+text);
                btn_10.setEnabled(false);
                break;

            case R.id.quess_button11:
                check_answer();
                text = btn_11.getText().toString();
                editText.setText(editText.getText().toString()+text);
                btn_11.setEnabled(false);
                break;

            case R.id.quess_button12:
                check_answer();
                text = btn_12.getText().toString();
                editText.setText(editText.getText().toString()+text);
                btn_12.setEnabled(false);
                break;
            case R.id.output_text:

                btn_1.setEnabled(true);
                btn_2.setEnabled(true);
                btn_3.setEnabled(true);
                btn_4.setEnabled(true);
                btn_5.setEnabled(true);
                btn_6.setEnabled(true);
                btn_7.setEnabled(true);
                btn_8.setEnabled(true);
                btn_9.setEnabled(true);
                btn_10.setEnabled(true);
                btn_11.setEnabled(true);
                btn_12.setEnabled(true);
                editText.setText("");
                break;

        }
    }

    private void question_generate(){
        list = new ArrayList<>();

        for (int i = 0;i< new Media().medias.length;i++){
            list.add(new Database(new Media().medias[i],new Media().media_logo[i]));
        }
        Collections.shuffle(list);
        Images_guess.setImageResource(list.get(0).getMedia_logo());

        List<String> button_content = new ArrayList<String>(Arrays.asList(list.get(0).getMedia().toString().split("")));
        button_content.remove(0);
        List<String> letter_content = new ArrayList<>(Arrays.asList(letters));

        if(button_content.size() < 12){
            Collections.shuffle(letter_content);
            int guess_name_size = 12 - button_content.size();
            for (int i=0;i< guess_name_size;i++){
                button_content.add(letter_content.get(i));
            }
            Collections.shuffle(button_content);
            btn_1.setText(button_content.get(0));
            btn_2.setText(button_content.get(1));
            btn_3.setText(button_content.get(2));
            btn_4.setText(button_content.get(3));
            btn_5.setText(button_content.get(4));
            btn_6.setText(button_content.get(5));
            btn_7.setText(button_content.get(6));
            btn_8.setText(button_content.get(7));
            btn_9.setText(button_content.get(8));
            btn_10.setText(button_content.get(9));
            btn_11.setText(button_content.get(10));
            btn_12.setText(button_content.get(11));
        }

        textanswer = list.get(0).getMedia().toString();
    }

    private void check_answer(){
        Text_checker.setText(textanswer);
    }

}
