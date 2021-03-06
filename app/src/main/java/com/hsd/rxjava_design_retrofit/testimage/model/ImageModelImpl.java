package com.hsd.rxjava_design_retrofit.testimage.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;

import com.hsd.rxjava_design_retrofit.testimage.ImageAll;
import com.hsd.rxjava_design_retrofit.testimage.inter.ImageInter;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 16/9/8.
 */
public class ImageModelImpl implements ImageAll.ImageModel {


    @Override
    public Observable<Bitmap> getBitmap(String url) {

//        OkHttpClient okHttpClient = new OkHttpClient();
//        Retrofit retrofit = new Retrofit.Builder()
//                .client(okHttpClient)
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .baseUrl(url)
//                .build();

        Retrofit re = new Retrofit.Builder()
                .client(new OkHttpClient())
                .addConverterFactory(BitmapConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(url)
                .build();



        return  re.create(ImageInter.class)
                .getBitmap2(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());




//        return re.create(ImageInter.class)
//                .getBitmap(url)
//                .subscribeOn(Schedulers.io())
//                .map(new Func1<ResponseBody, Bitmap>() {
//                    @Override
//                    public Bitmap call(ResponseBody responseBody) {
//                        return getBitmap(responseBody);
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread());





//        ImageInter imageInter = retrofit.create(ImageInter.class);
//        return imageInter.getBitmap(url)
//                .subscribeOn(Schedulers.io())
//                .map(new Func1<ResponseBody, Bitmap>() {
//                    @Override
//                    public Bitmap call(ResponseBody body) {
//                        byte[] bytes = new byte[0];
//                        try {
//                            bytes = body.bytes();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                    }
//
//                });

    }
    private Bitmap getBitmap(ResponseBody responseBody) {
        byte[] bytes = new byte[0];
        try {
            bytes = responseBody.bytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

}
