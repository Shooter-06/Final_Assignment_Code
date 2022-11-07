package com.example.finalassignment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolder extends RecyclerView.ViewHolder {

    CircleImageView URL;
    TextView albumId;
    TextView id;
    TextView title;
    CircleImageView thumbnailURL;
    ConstraintLayout parentLayout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        URL = itemView.findViewById(R.id.URL);
        albumId = itemView.findViewById(R.id.albumId);
        id = itemView.findViewById(R.id.id);
        title = itemView.findViewById(R.id.title);
        thumbnailURL = itemView.findViewById(R.id.thumbnailURL);
        parentLayout = itemView.findViewById(R.id.parent);

    }
}
