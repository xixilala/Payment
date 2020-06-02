package com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.autoai.firstdevelopmet.payment.R;
import com.autoai.firstdevelopmet.payment.base.BaseMvpActivity;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.adapter.PaymentFragmentsAdapter;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.contract.PaymentContract;
import com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.presenter.PaymentPresenter;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.ll_left_parent)
    LinearLayout llLeftParent;
    @BindView(R.id.tv_my_order)
    TextView tvMyOrder;
    @BindView(R.id.tv_smart_add_gas)
    TextView tvSmartAddGas;
    @BindView(R.id.iv_my_order)
    ImageView ivMyOrder;
    @BindView(R.id.iv_smart_add_sag)
    ImageView ivSmartAddSag;
    //是否登录
    private boolean isLogin = false;

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
            llTitle.setVisibility(View.GONE);
            llLeftParent.setVisibility(View.GONE);
        } else {
            llTitle.setVisibility(View.VISIBLE);
            llLeftParent.setVisibility(View.VISIBLE);
            showPage();
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
                llTitle.setVisibility(View.VISIBLE);
                llLeftParent.setVisibility(View.VISIBLE);
                showPage();
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
                setNavigationBarState(false);
                break;
            case R.id.ll_my_order:
                setNavigationBarState(true);
                break;
        }
    }

    private void showPage(){
        setNavigationBarState(false);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(SmartAddGasolineFragment.newInstance("加载智能加油"));
        fragments.add(MyOrderFragment.newInstance("我的订单"));
        viewpager.setOffscreenPageLimit(0);
        PaymentFragmentsAdapter adapter = new PaymentFragmentsAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
    }

    /***
     * 导航栏状态
     * @param isSelectOrderList 是否选中我的订单
     */
    private void setNavigationBarState(boolean isSelectOrderList){
        if (isSelectOrderList){
            //背景，文字，图标
            llMyOrder.setBackgroundColor(getColor(R.color._242B47));
            tvMyOrder.setTextColor(getColor(R.color.color_text_white));
            ivMyOrder.setImageResource(R.mipmap.left_order_selected);

            llSmartAddSagoline.setBackground(null);
            tvSmartAddGas.setTextColor(getColor(R.color.ffc8c8c8));
            ivSmartAddSag.setImageResource(R.mipmap.left_smart_add_gas);
            viewpager.setCurrentItem(1, true);
        } else {
            llSmartAddSagoline.setBackgroundColor(getColor(R.color._242B47));
            tvSmartAddGas.setTextColor(getColor(R.color.color_text_white));
            ivSmartAddSag.setImageResource(R.mipmap.left_smart_add_gas_selected);

            llMyOrder.setBackground(null);
            tvMyOrder.setTextColor(getColor(R.color.ffc8c8c8));
            ivMyOrder.setImageResource(R.mipmap.left_order);
            viewpager.setCurrentItem(0,true);
        }
    }
}
