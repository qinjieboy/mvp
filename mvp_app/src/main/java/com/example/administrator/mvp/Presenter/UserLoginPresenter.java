package com.example.administrator.mvp.Presenter;

import android.util.Log;

import com.example.administrator.mvp.model.IUserLoginModel;
import com.example.administrator.mvp.view.IUserLoginView;
import com.example.administrator.mvp.bean.User;
import com.example.administrator.mvp.model.OnLoginListener;
import com.example.administrator.mvp.model.impl.IUserLoginModelImpl;

/**
 * Created by Administrator on 2017\7\16 0016.
 */

public class UserLoginPresenter {

    private IUserLoginModel iModel;
    private IUserLoginView userLoginView;
    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.iModel = new IUserLoginModelImpl();
    }


public void login() {
    userLoginView.showLoading();
    iModel.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
        @Override
        public void loginSuccess(final User user) {
            Log.e("TAG","loginSuccess:"+Thread.currentThread().getName());
            //需要在UI线程执行
            userLoginView.toMainActivity(user);
            userLoginView.hideLoading();
        }

        @Override
        public void loginFailed() {
            //需要在UI线程执行
            userLoginView.showFailedError();
            userLoginView.hideLoading();

        }
    });
}
    /**
     * 请求数据
     */
    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
