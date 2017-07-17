package com.example.administrator.mvp.model;

/**
 * Created by Administrator on 2017\7\16 0016.
 */

public interface IUserLoginModel {

    public void login(String username, String password, OnLoginListener  loginListener);
}
