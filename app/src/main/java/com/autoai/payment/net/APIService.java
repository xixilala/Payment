package com.autoai.payment.net;

import com.autoai.payment.base.BaseObjectBean;
import com.autoai.payment.functionmodels.login.bean.LoginBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Nxp on 2020-05-17.
 */
public interface APIService {

    @FormUrlEncoded
    @POST("user/login")
    Flowable<BaseObjectBean<LoginBean>> login(@Field("username") String username,
                                              @Field("password") String password);
}
