package com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.viewpager.widget.ViewPager;

import com.autoai.firstdevelopmet.payment.R;
import com.autoai.firstdevelopmet.payment.base.BaseMvpActivity;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.contract.PaymentContract;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.presenter.PaymentPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentActivity extends BaseMvpActivity<PaymentPresenter> implements PaymentContract.View {

    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.ll_smart_add_sagoline)
    LinearLayout llSmartAddSagoline;
    @BindView(R.id.ll_my_order)
    LinearLayout llMyOrder;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    //是否登录
    private boolean isLogin = true;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_payment;
    }

    @Override
    protected void initData() {
        mPresenter = new PaymentPresenter();
        mPresenter.attachView(this);
        //未登录，提示登录
        if (!isLogin) {
            showLoginDialog();
        }
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

    private void showLoginDialog() {
        AlertDialog.Builder loginDialogBuilder = new AlertDialog.Builder(this);
        View v = LayoutInflater.from(this).inflate(R.layout.dialog_custom_alert, null);
        Button login = v.findViewById(R.id.btn_logindialog_login);
        Button cancel = v.findViewById(R.id.btn_logindialog_cancel);
        loginDialogBuilder.setView(v);
        loginDialogBuilder.setCancelable(false);
        AlertDialog loginDialog = loginDialogBuilder.create();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentActivity.this, "登录逻辑", Toast.LENGTH_SHORT).show();
                loginDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog.dismiss();
            }
        });
        loginDialog.show();
    }

    @OnClick({R.id.tv_search, R.id.ll_smart_add_sagoline, R.id.ll_my_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_search:
                break;
            case R.id.ll_smart_add_sagoline:
                break;
            case R.id.ll_my_order:
                break;
        }
    }
}
