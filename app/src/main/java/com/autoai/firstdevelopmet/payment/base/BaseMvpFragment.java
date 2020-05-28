package com.autoai.firstdevelopmet.payment.base;

/**
 * Created by Nxp on 2020-05-17.
 */
public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    protected T mPresenter;

    @Override
    public void onDestroyView() {
        if (mPresenter != null){
            mPresenter.detachView();
        }
        super.onDestroyView();
    }
}
