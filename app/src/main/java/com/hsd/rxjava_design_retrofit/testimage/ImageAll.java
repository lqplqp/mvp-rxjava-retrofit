package com.hsd.rxjava_design_retrofit.testimage;

import android.graphics.Bitmap;

import rx.Observable;

/**
 * Created by apple on 16/9/8.
 */
public interface ImageAll {

    interface ImageActivity {
        void updateRecycleView(Bitmap bitmap);
    }

    interface ImageModel {
        Observable<Bitmap> getBitmap(String url);
    }

    interface ImagePresenter {
        void loadImage();
    }

}
