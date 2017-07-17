package com.example.administrator.mvp.model;

import com.example.administrator.mvp.bean.User;

/**
 * Created by Administrator on 2017\7\16 0016.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();

}
