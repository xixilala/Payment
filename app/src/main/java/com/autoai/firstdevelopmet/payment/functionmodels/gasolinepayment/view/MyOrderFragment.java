package com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.view;

import android.view.View;

import com.autoai.firstdevelopmet.payment.base.BaseMvpFragment;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.contract.MyOrderContract;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.presenter.MyOrderPresenter;

public class MyOrderFragment extends BaseMvpFragment<MyOrderPresenter> implements MyOrderContract.View {
    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
