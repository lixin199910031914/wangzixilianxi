package com.example.xuexihaohaohao.presenter;

public class PresenterImpl extends ZhanPresenter.hPresenter {
    protected  IBaseView iBaseView;
    public PresenterImpl(IBaseView iBaseView) {
        super(iBaseView);
        this.iBaseView=iBaseView;
    }

    @Override
    public void getDDtt(String pach) {

    }
}
