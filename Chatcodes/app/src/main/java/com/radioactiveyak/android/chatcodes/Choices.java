package com.radioactiveyak.android.chatcodes;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Choices extends AppCompatActivity {

    ListView list;
    String web[] = {"COE/SE/IT", "ECE/EE/EEE", "CE", "ME/MAM", "MC", "EP", "PIE", "PCT", "ENE", "BT"};
    Integer imgId = R.drawable.ic_add_circle_outline_black_24dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);

        CustomList adapter = new CustomList(this, web, imgId);
        list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
        final int[] count = new int[100];
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.txt);
                ImageView imageView = (ImageView) view.findViewById(R.id.img);

                if(count[position] == 0) {
                    textView.setTextColor(Color.parseColor("#0288D1"));
                    imageView.setImageResource(R.drawable.ic_remove_circle_outline_black_24dp);
                    count[position] = 1;
                }
                else {
                    textView.setTextColor(Color.parseColor("#616161"));
                    imageView.setImageResource(R.drawable.ic_add_circle_outline_black_24dp);
                    count[position] = 0;
                }
            }

        }
        );

    }
}
