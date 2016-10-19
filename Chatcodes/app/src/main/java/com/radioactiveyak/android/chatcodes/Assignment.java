package com.radioactiveyak.android.chatcodes;

/**
 * Created by Aditya on 18/10/2016.
 */

public class Assignment {

    long AID;
    String Name;
    String Branch;
    String College;
    int Year;
    int Status;
    int QCount;
    String Uploader;
    long UploaderUID;

    public Assignment(long aid, String name, String branch, String college, int year, int qcount,
                      String uploader, long uploaderuid){
        AID = aid;
        Name = name;
        Branch = branch;
        College = college;
        Year = year;
        QCount = qcount;
        Uploader = uploader;
        UploaderUID = uploaderuid;
        Status = 0;
    }

    public int getQCount() {
        return QCount;
    }

    public int getStatus() {
        return Status;
    }

    public int getYear() {
        return Year;
    }

    public long getAID() {
        return AID;
    }

    public long getUploaderUID() {
        return UploaderUID;
    }

    public String getBranch() {
        return Branch;
    }

    public String getCollege() {
        return College;
    }

    public String getName() {
        return Name;
    }

    public String getUploader() {
        return Uploader;
    }

    public void setAID(long AID) {
        this.AID = AID;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public void setCollege(String college) {
        College = college;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setQCount(int QCount) {
        this.QCount = QCount;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public void setUploader(String uploader) {
        Uploader = uploader;
    }

    public void setUploaderUID(long uploaderUID) {
        UploaderUID = uploaderUID;
    }

    public void setYear(int year) {
        Year = year;
    }
}
