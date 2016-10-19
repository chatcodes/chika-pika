package com.radioactiveyak.android.chatcodes;

import java.util.ArrayList;

/**
 * Created by Aditya on 18/10/2016.
 */

public class Question {

    long QUID;
    long AID;
    String Name;
    int Status;
    String AnsweredBy;
    long AnswererUID;
    float Rating;
    ArrayList<String> AnswerIMGS;

    public Question(long quid, long aid, String name){
        QUID = quid;
        AID = aid;
        Name = name;
        Status = 0;
        AnsweredBy = "";
        AnswererUID = 0;
        Rating = 0;
        AnswerIMGS = new ArrayList<String>();
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAID(long AID) {
        this.AID = AID;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public void setAnsweredBy(String answeredBy) {
        AnsweredBy = answeredBy;
    }

    public void setAnswererUID(long answererUID) {
        AnswererUID = answererUID;
    }

    public void setQUID(long QUID) {
        this.QUID = QUID;
    }

    public void setRating(float rating) {
        Rating = rating;
    }

    public void setAnswerIMGS(ArrayList<String> answerIMGS) {
        AnswerIMGS = answerIMGS;
    }
}
