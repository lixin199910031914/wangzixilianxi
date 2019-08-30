package com.example.xuexihaohaohao.presenter;

public interface ZhanPresenter {
    interface  iView extends IBaseView{}
    abstract  class  hPresenter extends BasePresenter{
        public hPresenter(IBaseView iBaseView) {
            super(iBaseView);
        }
        public  abstract  void  getDDtt(String pach);
    }
}
