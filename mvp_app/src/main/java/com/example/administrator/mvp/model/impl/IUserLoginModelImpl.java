package com.example.administrator.mvp.model.impl;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.mvp.bean.User;
import com.example.administrator.mvp.model.IUserLoginModel;
import com.example.administrator.mvp.model.OnLoginListener;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


/**
 * Created by Administrator on 2017\7\16 0016.
 */

public class IUserLoginModelImpl implements IUserLoginModel {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        String url = "http://47.93.118.241:8081/android/user/login?";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username", username)
                .addParams("password", password)
                .addParams("phone", "18601042258")
                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "请求失败" + e.getMessage());
                        if (loginListener != null) {
                            loginListener.loginFailed();
                        }
                    }

                    @Override
                    public void onResponse(final String response, int id) {
                        Log.e("TAG", "请求成功" + response);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                User user = new Gson().fromJson(response, User.class);
                                //模拟登录成功
                                if (user.getStatus() == 200) {
                                    loginListener.loginSuccess(user);
                                } else {
                                    loginListener.loginFailed();
                                }
                            }
                        }, 2000);


                    }
                });

    }
}

