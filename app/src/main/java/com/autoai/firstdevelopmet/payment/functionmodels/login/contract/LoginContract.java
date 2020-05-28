package com.autoai.firstdevelopmet.payment.functionmodels.login.contract;

import com.autoai.firstdevelopmet.payment.base.BaseObjectBean;
import com.autoai.firstdevelopmet.payment.base.BaseView;
import com.autoai.firstdevelopmet.payment.functionmodels.login.bean.LoginBean;

import io.reactivex.Flowable;

/**
 * Created by Nxp on 2020-05-17.
 */
public interface LoginContract {

    interface Model{
        Flowable<BaseObjectBean<LoginBean>> login(String username, String password);
    }

    interface View extends BaseView{
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(BaseObjectBean<LoginBean> bean);
    }

    interface Presenter{
        void login(String username, String password);
    }
}
