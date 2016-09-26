package com.hsd.rxjava_design_retrofit.testimage.model;

import android.util.Log;

import rx.Observable;
import rx.Observer;

/**
 * Created by apple on 16/9/26.
 */
public abstract class MyObserver<T> implements Observer<T> {

    @Override
    public void onCompleted() {
        Log.i("onCompleted" , "onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        Log.i("onError" , "onError");
    }

}
