package com.autoai.firstdevelopmet.payment.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Nxp on 2020-05-16.
 */
public abstract class BaseFragment extends Fragment {

    protected final String TAG = "BaseFragment";
    private Unbinder mUnbinder;
    //视图是否已经初始化
    protected boolean isInit = false;
    protected boolean isLoad = false;
    private View mView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(this.getLayoutId(), container, false);
        isInit = true;
        mUnbinder = ButterKnife.bind(this, mView);
        initView(mView);
        //初始化时去加载数据
        isCanLoadDate();
        return mView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadDate();
    }

    /**
     * 是否可以加载数据
     * 可以加载数据的条件：
     * 1.视图已经初始化
     * 2.视图对用户可见
     */
    private void isCanLoadDate(){
        if (!isInit){
            return;
        }
        //当视图可见，并且没有加载过数据
        if (getUserVisibleHint() && !isLoad){
            lazyLoad();
            isLoad = true;
        } else {
            if (isLoad){
                stopLoad();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        isInit = false;
        isLoad = false;
    }

    /**
     * 初始化视图
     * @param view
     */
    protected abstract void initView(View view);

    /**
     * 绑定layout
     * @return
     */
    protected abstract int getLayoutId();

    protected View getCurrentView(){
        return mView;
    }

    /**
     * 当视图初始化，并且对用户可见的时候，去真正的加载数据
     */
    protected abstract void lazyLoad();

    /**
     * 当试图已经对用户不可见，并且加载过数据，如果需要在切换到其他页面时停止加载数据，调用此方法
     */
    protected void stopLoad(){
        isLoad = false;
    }
}
