package com.example.finalassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<String> myAlbumId = new ArrayList<>();
    private ArrayList<String> myId = new ArrayList<>();
    private ArrayList<String> myTitle = new ArrayList<>();
    private ArrayList<String> myURL = new ArrayList<>();
    private ArrayList<String> myThumbnailURL = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> myAlbumId, ArrayList<String> myId,
                               ArrayList<String> myTitle, ArrayList<String> myURL,
                               ArrayList<String> myThumbnailURL, Context mContext) {
        this.myAlbumId = myAlbumId;
        this.myId = myId;
        this.myTitle = myTitle;
        this.myURL = myURL;
        this.myThumbnailURL = myThumbnailURL;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_child, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(myURL.get(position))
                .into(holder.URL);

        Glide.with(mContext)
                .asBitmap()
                .load(myThumbnailURL.get(position))
                .into(holder.thumbnailURL);

        holder.albumId.setText(myAlbumId.get(position));
        holder.id.setText(myId.get(position));
        holder.title.setText(myTitle.get(position));
    }

    @Override
    public int getItemCount() {
        return myURL.size();
    }
}
