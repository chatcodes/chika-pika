package com.radioactiveyak.android.chatcodes;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aditya on 19/10/2016.
 */

public class AssignmentListAdapter extends ArrayAdapter<Assignment> {

    Context context;

    public AssignmentListAdapter(Context context, int resource, List<Assignment> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    public class ViewHolder{
        TextView tname;
        TextView tstatus;
        TextView uploader;
        Assignment assignment;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Assignment rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) parent.getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.assignment_list_item, null);
            holder = new ViewHolder();
            holder.tname = (TextView)convertView.findViewById(R.id.assignment_item_name);
            holder.tstatus = (TextView)convertView.findViewById(R.id.assignment_item_status);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.tname.setText(rowItem.getName() + " - " + rowItem.getYear() + " - " + rowItem.getBranch() );
        if(rowItem.getStatus() == 0){
            holder.tstatus.setText(" Not Answered ");
            holder.tstatus.setTextColor(Color.RED);
        }
        else if(rowItem.getStatus() == 1){
            holder.tstatus.setText(" Partially Answered ");
            holder.tstatus.setTextColor(Color.YELLOW);
        }
        else if(rowItem.getStatus() == 2){
            holder.tstatus.setText(" Completely Answered ");
            holder.tstatus.setTextColor(Color.GREEN);
        }

        holder.assignment = rowItem;


        return convertView;
    }
}
