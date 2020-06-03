package com.autoai.payment.functionmodels.login.model;

import com.autoai.payment.base.BaseObjectBean;
import com.autoai.payment.functionmodels.login.bean.LoginBean;
import com.autoai.payment.functionmodels.login.contract.LoginContract;
import com.autoai.payment.net.RetrofitClient;

import io.reactivex.Flowable;

/**
 * Created by Nxp on 2020-05-17.
 */
public class LoginModel implements LoginContract.Model {
    @Override
    public Flowable<BaseObjectBean<LoginBean>> login(String username, String password) {
        return RetrofitClient.getInstance().getApi().login(username, password);
    }
}
