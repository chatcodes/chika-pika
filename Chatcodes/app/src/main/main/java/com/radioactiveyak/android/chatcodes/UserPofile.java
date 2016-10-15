package com.radioactiveyak.android.chatcodes;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserPofile extends AppCompatActivity {


    static final String TAG_IMGURL = "pic";
    static final String TAG_USERNAME = "username";
    static final String TAG_NAME = "name";
    static final String TAG_FIRSTNAME = "first";
    static final String TAG_LASTNAME = "last";
    static final String TAG_RATING = "rating";
    static final String TAG_QLIST = "Qanswered";


    JSONObject c;
    Bitmap bmp;
    double rating;
    ProgressDialog pDialog;
    static final String REQ = "";

    ImageView profilePic;
    TextView fullName;
    TextView userRating;
    ListView userAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pofile);

        profilePic = (ImageView)findViewById(R.id.user_profile_pic);
        fullName = (TextView)findViewById(R.id.user_profile_name);
        userRating = (TextView)findViewById(R.id.user_profile_rating);
        userAnswers = (ListView)findViewById(R.id.user_profile_ans_list);

        new LoadProfile().execute();


    }



    class LoadProfile extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(UserPofile.this);
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
            final JSONArray jsonArray = new JSONParser().makeHttpRequest(REQ);



            // Check your log cat for JSON reponse
            //Log.d("All posts: ", json.toString());

            try {
                // looping through All posts
                c = jsonArray.getJSONObject(0);
                bmp = getBitmapFromURL(c.getString(TAG_IMGURL));

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

                    profilePic.setImageBitmap(bmp);
                    try {
                        fullName.setText(c.getString(TAG_FIRSTNAME).toString() + " " + c.getString(TAG_LASTNAME).toString());
                        rating = c.getDouble(TAG_RATING);
                        userRating.setText(Double.toString(rating));
                        if(rating >= 4.0){
                            userRating.setBackgroundColor(Color.parseColor("#0F9611"));
                        }
                        else if(rating >= 2.5){
                            userRating.setBackgroundColor(Color.parseColor("#EA6C04"));
                        }
                        else{
                            userRating.setBackgroundColor(Color.parseColor("#E02100"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    pDialog.dismiss();

                }
            });

        }

    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src", src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }


}
