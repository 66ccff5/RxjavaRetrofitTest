package com.example.administrator.rxjavaretrofittest.view.presenter;

import com.example.administrator.rxjavaretrofittest.view.model.IModel;
import com.example.administrator.rxjavaretrofittest.view.model.ImodelImp;
import com.example.administrator.rxjavaretrofittest.view.bean.Translation;

import com.example.administrator.rxjavaretrofittest.view.ui.IActivity;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/9/19 0019.
 */


//在presenter中调用activity与model中方法完成操作
public class Presenter {
    IActivity mActivity;
    IModel mModel;

    Translation.TranslateResultBean d;

    public Presenter(IActivity actcivty){
        mActivity = actcivty;
        mModel = new ImodelImp();
    }

    public void setData(){






        Subscription subscription = mModel.getData().getCall("just test").subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
//                .doOnNext(new Action1<Translation>() {
//                    @Override
//                    public void call(Translation translation) {
//                        d = translation.getTranslateResult().get(0).get(0);
//                    }
//                })
                .flatMap(new Func1<Translation, Observable<Translation.TranslateResultBean>>() {
                    @Override
                    public Observable<Translation.TranslateResultBean> call(Translation data) {
                        return Observable.from(data.getTranslateResult().get(0));
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Translation.TranslateResultBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Translation.TranslateResultBean translation) {
                        d = translation;
                        System.out.println("uuuuuuuuuu  " + d.getTgt());
                        mActivity.setTextViewData(d.getTgt());
                    }
                });

    }


}
