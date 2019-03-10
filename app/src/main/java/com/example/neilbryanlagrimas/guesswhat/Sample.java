package com.example.neilbryanlagrimas.guesswhat;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.neilbryanlagrimas.guesswhat.DatabaseContainer.DatabaseHelper;

import java.util.ArrayList;

public class Sample extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<String>strings;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        databaseHelper = new DatabaseHelper(this);
        listView = (ListView) findViewById(R.id.listview_id);
        Cursor cursor = databaseHelper.viewdata();

        if (cursor.getCount() >=1){
            Toast.makeText(this,"DATA detected",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"DATA not detected",Toast.LENGTH_SHORT).show();
        }

        StringBuffer stringBuffer = new StringBuffer();

        strings = new ArrayList<>();
        while (cursor.moveToNext()){
           /* stringBuffer.append("Score : "+cursor.getInt(0)+"\n");

            stringBuffer.append("Name : "+cursor.getString(1)+"\n\n");
            */
           strings.add(cursor.getString(1));
           listAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,strings);
           listView.setAdapter(listAdapter);
        }

       // scoredata_1.setText(stringBuffer.toString());


    }
}
