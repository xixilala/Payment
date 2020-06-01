package com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.view;

import android.view.View;
import com.autoai.firstdevelopmet.payment.base.BaseMvpFragment;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.contract.SmartAddGosolineContract;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.presenter.SmartAddGasolinePresenter;

public class SmartAddGasolineFragment extends BaseMvpFragment<SmartAddGasolinePresenter> implements SmartAddGosolineContract.View {
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
