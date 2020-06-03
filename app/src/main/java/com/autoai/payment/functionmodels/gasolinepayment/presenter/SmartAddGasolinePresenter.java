package com.autoai.payment.functionmodels.gasolinepayment.presenter;

import com.autoai.payment.base.BasePresenter;
import com.autoai.payment.functionmodels.gasolinepayment.contract.SmartAddGosolineContract;
import com.autoai.payment.functionmodels.gasolinepayment.model.SmartAddGosolineModel;

public class SmartAddGasolinePresenter extends BasePresenter<SmartAddGosolineContract.View> implements SmartAddGosolineContract.Presenter {

    private SmartAddGosolineContract.Model mModel;

    public SmartAddGasolinePresenter(){
        mModel = new SmartAddGosolineModel();
    }
}
