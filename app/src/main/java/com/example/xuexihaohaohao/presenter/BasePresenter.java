package com.example.xuexihaohaohao.presenter;

public class BasePresenter  {
    private IBaseView iBaseView;

    public BasePresenter(IBaseView iBaseView) {
        this.iBaseView = iBaseView;
    }
    public  void  onDrestroy(){
        iBaseView=null;
    }
}
