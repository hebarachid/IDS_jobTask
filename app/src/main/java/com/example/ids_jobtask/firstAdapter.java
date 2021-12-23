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

public class firstAdapter extends RecyclerView.Adapter<firstAdapter.MyViewHolder>{
    private Context mContext;
    private List<page1GalleryInformation> mData;

    public firstAdapter(Context mContext, List<page1GalleryInformation> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater=LayoutInflater.from(mContext);
        v=inflater.inflate(R.layout.gallery_first_page_items,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.Name.setText(mData.get(position).getName());
        Glide.with(mContext).load(mData.get(position).getCroppedImage320x308()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
         TextView Name;
         ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            this.image = itemView.findViewById(R.id.CroppedImage320x308);
        }
    }

}
