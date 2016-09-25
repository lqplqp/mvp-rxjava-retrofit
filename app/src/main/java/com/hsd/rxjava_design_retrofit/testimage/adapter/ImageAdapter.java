package com.hsd.rxjava_design_retrofit.testimage.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hsd.rxjava_design_retrofit.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 16/9/8.
 */
public class ImageAdapter extends RecyclerView.Adapter {

    private List<Bitmap> images;

    public ImageAdapter() {
        images = new ArrayList<Bitmap>();
    }


    public void addImage(Bitmap image) {
        images.add(image);
        images.add(image);
    }


    public void addImages(List<Bitmap> images) {
        images.addAll(images);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.card_view, null);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Holder myHolder = (Holder) holder;
        myHolder.imageView.setImageBitmap(images.get(position));
        myHolder.textView.setText("当前图片为" + position);
    }

    @Override
    public int getItemCount() {
        return images == null ? 0 : images.size();
    }


    public void removeImage() {
        if (images.size() - 1 < 0) {
            return;
        }
        images.remove(images.size() - 1);
        this.notifyDataSetChanged();
    }


    static class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public Holder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.cardView_image);
            textView = (TextView) itemView.findViewById(R.id.cardView_text);
        }
    }


}
