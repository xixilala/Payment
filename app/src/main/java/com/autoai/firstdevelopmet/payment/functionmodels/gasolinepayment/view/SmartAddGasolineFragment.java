package com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.autoai.firstdevelopmet.payment.R;
import com.autoai.firstdevelopmet.payment.base.BaseMvpFragment;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.contract.SmartAddGosolineContract;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.presenter.SmartAddGasolinePresenter;

public class SmartAddGasolineFragment extends BaseMvpFragment<SmartAddGasolinePresenter> implements SmartAddGosolineContract.View {

    public static SmartAddGasolineFragment newInstance(String s){
        SmartAddGasolineFragment fragment = new SmartAddGasolineFragment();
        Bundle args = new Bundle();
        args.putString("testS", s);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if (args != null){
            String s = args.getString("testS");
            Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_smart_add_gasoline;
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