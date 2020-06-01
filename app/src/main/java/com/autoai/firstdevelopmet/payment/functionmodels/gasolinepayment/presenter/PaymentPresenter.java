package com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.presenter;

import com.autoai.firstdevelopmet.payment.base.BasePresenter;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.contract.PaymentContract;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.model.PaymentModel;

public class PaymentPresenter extends BasePresenter<PaymentContract.View> implements PaymentContract.Presenter {

    private PaymentContract.Model mModel;

    public PaymentPresenter(){
        mModel = new PaymentModel();
    }
}
