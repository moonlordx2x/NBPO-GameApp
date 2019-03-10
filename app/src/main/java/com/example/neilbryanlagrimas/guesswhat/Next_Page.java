package com.example.neilbryanlagrimas.guesswhat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.neilbryanlagrimas.guesswhat.DatabaseContainer.DatabaseHelper;

public class Next_Page extends AppCompatActivity {

    private DatabaseHelper DBHELPER;
    private int total_score;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next__page);
        DBHELPER = new DatabaseHelper(this);
        total_score = getIntent().getExtras().getInt("value");
        openDialog();
    }

    private void openDialog(){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        final EditText editText = new EditText(Next_Page.this);
        editText.setLayoutParams(layoutParams);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Enter a Name....");
        builder.setView(editText);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Editable editable = editText.getText();
                boolean insertdata = DBHELPER.insertdata(total_score, editable.toString());

                if (insertdata == true) {
                    Toast.makeText(Next_Page.this,"Success you finish the round",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Next_Page.this,"Error in saving the Score",Toast.LENGTH_SHORT).show();
                }
                finish();
                startActivity(new Intent(Next_Page.this,Start_Activity.class));
            }

        });
        builder.create().show();
    }

}
