package com.example.administrator.mvp.view;

import com.example.administrator.mvp.bean.User;

/**
 * Created by Administrator on 2017\7\16 0016.
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

}
