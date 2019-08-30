package com.example.xuexihaohaohao.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.xuexihaohaohao.presenter.BasePresenter;
import com.example.xuexihaohaohao.presenter.PresenterImpl;

public abstract class BaseActivity  extends AppCompatActivity {
    protected PresenterImpl presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (initLayout()!=0){
            setContentView(initLayout());
            initView();
            initPresenter();
            initData();
        }

    }
    protected abstract int initLayout();
    protected abstract void initView();
    protected abstract BasePresenter initPresenter();

    protected abstract void initData();



}
