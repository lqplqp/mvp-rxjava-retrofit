package com.hsd.rxjava_design_retrofit.testimage.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.hsd.rxjava_design_retrofit.R;
import com.hsd.rxjava_design_retrofit.testimage.ImageAll;
import com.hsd.rxjava_design_retrofit.testimage.adapter.ImageAdapter;
import com.hsd.rxjava_design_retrofit.testimage.presenter.ImagePresenterImpl;

/**
 * Created by apple on 16/9/8.
 */
public class ImageActivity extends Activity implements ImageAll.ImageActivity, View.OnClickListener {

    private String TAG = "ImageActivity";

    private RecyclerView recyclerView;

    private ImageAdapter mAdapter;

    private ImageAll.ImagePresenter mPresenter;

    private View button;
    private View remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyView);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        remove = findViewById(R.id.remove);
        remove.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ImageAdapter();

        recyclerView.setAdapter(mAdapter);
        mPresenter = new ImagePresenterImpl(this);
        mPresenter.loadImage();
    }


    @Override
    public void updateRecycleView(Bitmap bitmap) {
        mAdapter.addImage(bitmap);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            Log.i(TAG, "点击按钮");
            mPresenter.loadImage();
        }
        if (v.getId() == R.id.remove) {
            removeImage();
        }
    }

    public void removeImage() {
        mAdapter.removeImage();
    }
}
