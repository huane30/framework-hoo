package com.hoo.framework.mybatis.entity;

/**
 * Created by ravihoo on 07/03/2018.
 */
public class User {

    private String id;

    private String userName;

    private int age;

    private String ctm;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCtm() {
        return ctm;
    }

    public void setCtm(String ctm) {
        this.ctm = ctm;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

