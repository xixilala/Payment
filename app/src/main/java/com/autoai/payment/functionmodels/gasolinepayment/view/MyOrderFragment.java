package com.autoai.payment.functionmodels.gasolinepayment.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.autoai.payment.R;
import com.autoai.payment.base.BaseMvpFragment;
import com.autoai.payment.functionmodels.gasolinepayment.contract.MyOrderContract;
import com.autoai.payment.functionmodels.gasolinepayment.presenter.MyOrderPresenter;

public class MyOrderFragment extends BaseMvpFragment<MyOrderPresenter> implements MyOrderContract.View {

    public static MyOrderFragment newInstance(String s){
        MyOrderFragment fragment = new MyOrderFragment();
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
        return R.layout.fragment_my_order;
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
