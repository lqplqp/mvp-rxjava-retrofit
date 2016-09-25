package com.hsd.rxjava_design_retrofit.testimage.presenter;


import android.graphics.Bitmap;
import android.util.Log;

import com.hsd.rxjava_design_retrofit.testimage.ImageAll;
import com.hsd.rxjava_design_retrofit.testimage.model.ImageModelImpl;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 16/9/8.
 */
public class ImagePresenterImpl implements ImageAll.ImagePresenter {

    private String TAG = " ImagePresenterImpl";

    ImageAll.ImageActivity mActivity;

    ImageAll.ImageModel mMoudle;

    public ImagePresenterImpl(ImageAll.ImageActivity mActivity) {
        this.mActivity = mActivity;
        this.mMoudle = new ImageModelImpl();
    }

    @Override
    public void loadImage() {
        mMoudle.getBitmap("http://i2.17173cdn.com/2fhnvk/YWxqaGBf/cms3/fADFcjbkCbwrcch.jpg/")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bitmap>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted2");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.i(TAG, "onError2");
                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        mActivity.updateRecycleView(bitmap);
                    }
                });
    }

}
