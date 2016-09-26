package com.hsd.rxjava_design_retrofit.testimage.inter;

import android.graphics.Bitmap;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by apple on 16/9/8.
 */
public interface ImageInter {
    @GET
    Observable<ResponseBody> getBitmap(@Url String url);

    @GET
    Observable<Bitmap> getBitmap2(@Url String url);
}
