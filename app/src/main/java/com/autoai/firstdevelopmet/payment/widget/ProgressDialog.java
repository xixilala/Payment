package com.autoai.firstdevelopmet.payment.widget;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by Nxp on 2020-05-17.
 */
public class ProgressDialog {

    private static volatile ProgressDialog instance;

    private ProgressDialog(){}

    public static ProgressDialog getInstance(){
        if (instance == null){
            synchronized (ProgressDialog.class){
                if (instance == null){
                    instance = new ProgressDialog();
                }
            }
        }
        return instance;
    }

    private MaterialDialog mMaterialDialog;

    public void show(Context context){
        mMaterialDialog = new MaterialDialog.Builder(context)
                .content("Please wait...")
                .progress(true, 0)
                .cancelable(false)
                .progressIndeterminateStyle(false)
                .show();
    }

    public void dismiss(){
        mMaterialDialog.dismiss();
    }
}
