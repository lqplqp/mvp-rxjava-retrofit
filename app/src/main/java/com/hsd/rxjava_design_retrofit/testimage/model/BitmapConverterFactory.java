package com.hsd.rxjava_design_retrofit.testimage.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by apple on 16/9/26.
 */
public class BitmapConverterFactory extends Converter.Factory{

    private BitmapConverterFactory() {
        super();
    }
    public static BitmapConverterFactory create() {
        return new BitmapConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new BitmapResponseBodyConverter();
    }

}
