package com.radioactiveyak.android.chatcodes;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.radioactiveyak.android.chatcodes.UserPofile.getBitmapFromURL;

/**
 * Created by Aditya on 19/10/2016.
 */

public class tempp {

    ListView lv;
    ProgressDialog pDialog;
    ArrayList<Assignment> plist = new ArrayList<Assignment>();

    static final String TAG_IMGURL = "pic";
    static final String TAG_USERNAME = "username";
    static final String TAG_ASSIGNNAME = "name";
    static final String TAG_FIRSTNAME = "first";
    static final String TAG_LASTNAME = "last";
    static final String TAG_RATING = "rating";
    static final String TAG_QLIST = "Qanswered";
    static final String TAG_EMAIL = "email";
    static final String TAG_COLLEGE = "college";
    static final String TAG_AID = "aid";
    static final String TAG_STATUS = "status";
    static final String TAG_UPBY = "uploadby";
    static final String TAG_UUID = "uuid";
    static final String TAG_YEAR = "year";
    static final String TAG_QCOUNT = "qcount";
    static final String TAG_BRANCH = "branch";


    class LoadAllposts extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog();
            pDialog.setMessage("Loading posts. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * getting All posts from url
         * */
        protected String doInBackground(String... params) {

            // getting JSON string from URL
            final JSONArray jsonArray = new JSONParser().makeHttpRequest(AURL);

            // Check your log cat for JSON reponse
            //Log.d("All posts: ", json.toString());

            try {
                // looping through All posts
                plist.clear();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject c = jsonArray.getJSONObject(i);
                    // Storing each json item in variable
                    plist.add(new Assignment(c.getLong(TAG_AID),c.getString(TAG_ASSIGNNAME),c.getString(TAG_BRANCH),c.getString(TAG_COLLEGE),
                            c.getInt(TAG_YEAR),c.getInt(TAG_QCOUNT),c.getString(TAG_UPBY),c.getLong(TAG_UUID)));
                }
                //} else {
                //Toast.makeText(getApplicationContext(),"Network Error Occured",Toast.LENGTH_LONG).show();
                //}
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return "done";
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all posts

            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                    pDialog.dismiss();
                    if( plist.size() != 0 ){
                        //tv.setVisibility(View.INVISIBLE);
                        lv.setVisibility(View.VISIBLE);
                        AssignmentListAdapter adapter = new AssignmentListAdapter(getApplicationContext(),
                                R.layout.assignment_list_item,plist);
                        lv.setAdapter(adapter);
                    }
                    else{
                        lv.setVisibility(View.INVISIBLE);
                        //tv.setVisibility(View.VISIBLE);
                        //tv.setText("No posts yet for " + getTitle() + "!");
                    }
                }
            });

        }

        public void setuponclick(){
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    AssignmentListAdapter.ViewHolder holder = (AssignmentListAdapter.ViewHolder)view.getTag();
                    Intent intent = new Intent();
                    intent.putExtra(TAG_ASSIGNNAME,holder.assignment.getName());
                    intent.putExtra(TAG_AID,holder.assignment.getAID());
                    intent.putExtra(TAG_STATUS,holder.assignment.getStatus());


                }
            });
        }

    }





}
