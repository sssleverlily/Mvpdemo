package com.example.administrator.mydemo.model;

public interface Iuser {
    String getName();

    String getPasswd();

    int checkUserValidity(String name, String passwd);
}
