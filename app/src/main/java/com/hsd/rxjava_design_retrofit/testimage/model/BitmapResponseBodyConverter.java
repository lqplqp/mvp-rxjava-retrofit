package com.hsd.rxjava_design_retrofit.testimage.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by apple on 16/9/26.
 */
public class BitmapResponseBodyConverter implements Converter<ResponseBody, Bitmap> {
    @Override
    public Bitmap convert(ResponseBody value) throws IOException {
        return getBitmap(value);
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
