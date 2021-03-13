package com.example.mydrawabletobitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class ShowImageAdapter extends RecyclerView.Adapter<ShowImageAdapter.ViewHolder> {

    private List<Model> listImg;

    public ShowImageAdapter(List<Model> imgName) {
        this.listImg = imgName;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.drawable_adapter, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowImageAdapter.ViewHolder holder, int position) {
        holder.drawableName.setText(listImg.get(position).getName());

        holder.drawableName.setOnClickListener(view -> holder.image.setImageBitmap(listImg.get(position).getImg()));
    }


    @Override
    public int getItemCount() {
        return listImg.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public Button drawableName;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.image);
            this.drawableName = itemView.findViewById(R.id.drawableName);
        }
    }
}
