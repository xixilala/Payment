package com.autoai.payment.functionmodels.gasolinepayment.contract;

import com.autoai.payment.base.BaseView;

public interface PaymentContract {

    interface Model{

    }

    interface View extends BaseView{
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);
    }

    interface Presenter{

    }
}
