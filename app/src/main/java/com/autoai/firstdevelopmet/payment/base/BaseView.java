package com.autoai.firstdevelopmet.payment.base;

import com.uber.autodispose.AutoDisposeConverter;

/**
 * Created by Nxp on 2020-05-16.
 */
public interface BaseView {

    /**
     * 显示加载中
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 获取数据失败
     * @param throwable
     */
    void onError(Throwable throwable);

    /**
     * 绑定android生命周期,防止Rxjava内存泄漏
     * @param <T>
     * @return
     */
    <T> AutoDisposeConverter<T> bindAutoDispose();

}
