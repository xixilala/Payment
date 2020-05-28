package com.autoai.firstdevelopmet.payment.base;

/**
 * Created by Nxp on 2020-05-16.
 */
public class BasePresenter<V extends BaseView> {

    protected V mView;

    /**
     * 绑定view,初始化调用
     * @param view
     */
    public void attachView(V view){
        mView = view;
    }

    /**
     * 解除绑定
     */
    public void detachView(){
        mView = null;
    }


    public boolean isViewAttached(){
        return mView != null;
    }
}
