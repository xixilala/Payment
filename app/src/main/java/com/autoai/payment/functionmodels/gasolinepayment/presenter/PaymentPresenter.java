package com.autoai.payment.functionmodels.gasolinepayment.presenter;

import com.autoai.payment.base.BasePresenter;
import com.autoai.payment.functionmodels.gasolinepayment.contract.PaymentContract;
import com.autoai.payment.functionmodels.gasolinepayment.model.PaymentModel;

public class PaymentPresenter extends BasePresenter<PaymentContract.View> implements PaymentContract.Presenter {

    private PaymentContract.Model mModel;

    public PaymentPresenter(){
        mModel = new PaymentModel();
    }
}
