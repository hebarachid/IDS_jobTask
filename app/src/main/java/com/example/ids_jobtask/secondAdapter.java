package com.example.ids_jobtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class secondAdapter extends RecyclerView.Adapter<secondAdapter.MyViewHolder> {
    private Context mContext;
    private List<page2GalleryInformation> mData;

    public secondAdapter(Context mContext, List<page2GalleryInformation> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public secondAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater=LayoutInflater.from(mContext);
        v=inflater.inflate(R.layout.gallery_second_page_items,parent,false);
        return new secondAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull secondAdapter.MyViewHolder holder, int position) {
        holder.Caption.setText(mData.get(position).getCaption());
        Glide.with(mContext).load(mData.get(position).getCroppedImage320x308()).into(holder.image2);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Caption;
        ImageView image2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Caption = itemView.findViewById(R.id.Caption);
            this.image2 = itemView.findViewById(R.id.Cropped2Image320x308);
        }
    }

}
