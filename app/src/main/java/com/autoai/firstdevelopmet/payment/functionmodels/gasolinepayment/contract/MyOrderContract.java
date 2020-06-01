package com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.contract;

import com.autoai.firstdevelopmet.payment.base.BaseView;

public interface MyOrderContract {

    interface Model{

    }

    interface View extends BaseView {

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
