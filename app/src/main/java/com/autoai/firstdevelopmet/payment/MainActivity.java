package com.autoai.firstdevelopmet.payment;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.widget.Toast;

import com.autoai.firstdevelopmet.payment.base.BaseMvpActivity;
import com.autoai.firstdevelopmet.payment.base.BaseObjectBean;
import com.autoai.firstdevelopmet.payment.functionmodels.login.LoginPresenter;
import com.autoai.firstdevelopmet.payment.functionmodels.login.bean.LoginBean;
import com.autoai.firstdevelopmet.payment.functionmodels.login.contract.LoginContract;
import com.autoai.firstdevelopmet.payment.widget.ProgressDialog;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_username_login)
    TextInputEditText etUsernameLogin;
    @BindView(R.id.et_password_login)
    TextInputEditText etPasswordLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);
    }

    private String getUsername(){
        return etUsernameLogin.getText().toString().trim();
    }

    private String getPassword(){
        return etPasswordLogin.getText().toString().trim();
    }

    @Override
    public void onSuccess(BaseObjectBean<LoginBean> bean) {
        Toast.makeText(this, bean.getErrorMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideLoading() {
        ProgressDialog.getInstance().dismiss();
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_signin_login)
    public void onViewClicked(){
        mPresenter.login(getUsername(), getPassword());
    }
}
