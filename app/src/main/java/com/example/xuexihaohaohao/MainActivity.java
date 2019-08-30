package com.example.xuexihaohaohao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.xuexihaohaohao.model.Bean;
import com.example.xuexihaohaohao.model.RviewAdapter;
import com.example.xuexihaohaohao.presenter.BasePresenter;
import com.example.xuexihaohaohao.presenter.PresenterImpl;
import com.example.xuexihaohaohao.presenter.ZhanPresenter;
import com.example.xuexihaohaohao.view.BaseActivity;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class MainActivity extends BaseActivity implements ZhanPresenter.iView {
    private int page=1;
    private XRecyclerView r;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        r = findViewById(R.id.xrv);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl(this);

    }

    @Override
    protected void initData() {
        presenter= (PresenterImpl) initPresenter();
        presenter.getDDtt(Api.PACH);
        r.setLoadingMoreEnabled(true);
        r.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page++;
                initData();


            }

            @Override
            public void onLoadMore() {
                 page--;
                initData();
            }
        });
    }

    @Override
    public void onChenggong(Object obj) {
        Gson gson=new Gson();
        Bean bean = gson.fromJson(obj.toString(), Bean.class);
        List<Bean.BeanResult> result = bean.getResult();
        RviewAdapter adapter=new RviewAdapter(result, this);
        r.setAdapter(adapter);
        r.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onShibai(String meg) {

    }
}
