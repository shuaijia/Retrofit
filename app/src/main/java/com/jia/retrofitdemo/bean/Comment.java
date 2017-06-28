package com.jia.retrofitdemo.bean;

/**
 * Describtion:
 * Created by jia on 2017/3/10 0010.
 * 人之所以能，是相信能
 */
public class Comment {
    private String status;
    private String note;
    private String data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
