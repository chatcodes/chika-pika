package com.radioactiveyak.android.chatcodes;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Choices  extends Fragment{

    ListView list;
    String web[] = {"COE/SE/IT", "ECE/EE/EEE", "CE", "ME/MAM", "MC", "EP", "PIE", "PCT", "ENE", "BT"};
    Integer imgId = R.drawable.ic_add_circle_outline_black_24dp;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_choices);

        CustomList adapter = new CustomList(getActivity(), web, imgId);
        list = (ListView)getView().findViewById(R.id.listView);
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_choices, container, false);
    }
}
