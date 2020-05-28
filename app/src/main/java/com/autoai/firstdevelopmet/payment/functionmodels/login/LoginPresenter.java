package com.autoai.firstdevelopmet.payment.functionmodels.login;

import com.autoai.firstdevelopmet.payment.base.BaseObjectBean;
import com.autoai.firstdevelopmet.payment.base.BasePresenter;
import com.autoai.firstdevelopmet.payment.functionmodels.login.bean.LoginBean;
import com.autoai.firstdevelopmet.payment.functionmodels.login.contract.LoginContract;
import com.autoai.firstdevelopmet.payment.functionmodels.login.model.LoginModel;
import com.autoai.firstdevelopmet.payment.net.RxScheduler;

import io.reactivex.functions.Consumer;

/**
 * Created by Nxp on 2020-05-17.
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private LoginContract.Model mModel;

    public LoginPresenter(){
        mModel = new LoginModel();
    }
    @Override
    public void login(String username, String password) {
        //view是否绑定 如果没有绑定,就不执行网络请求
        if (!isViewAttached()){
            return;
        }
        mView.showLoading();
        mModel.login(username, password)
                .compose(RxScheduler.<BaseObjectBean<LoginBean>>Flo_io_main())
                .as(mView.<BaseObjectBean<LoginBean>>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<LoginBean>>() {
                    @Override
                    public void accept(BaseObjectBean<LoginBean> bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }
}
