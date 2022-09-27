package com.sqback.dao.entity;

public class StudentScore {
    private String sid;
    private String score;
    private String code;

    public StudentScore() {
        super();
    }

    public StudentScore(String sid, String score, String code) {
        this.sid = sid;
        this.score = score;
        this.code = code;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
