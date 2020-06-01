package com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.presenter;

import com.autoai.firstdevelopmet.payment.base.BasePresenter;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.contract.MyOrderContract;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.model.MyOrderModel;

public class MyOrderPresenter extends BasePresenter<MyOrderContract.View> implements MyOrderContract.Presenter{

    private MyOrderContract.Model mModel;

    public MyOrderPresenter() {
        mModel = new MyOrderModel();
    }
}
