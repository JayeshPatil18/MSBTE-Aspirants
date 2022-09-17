package com.msbteapp.msbtewallah;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {
    ArrayList<Item> list;
    Context context;

    public PostsAdapter(Context context, ArrayList<Item> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item model = list.get(position);
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());
        Glide.with(holder.imageView.getContext()).load(model.getImage()).into(holder.imageView);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(model.getLink().equals("null") || model.getLink().isEmpty())){
                    Uri uri = Uri.parse(model.getLink());
                    holder.layout.getContext().startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
            }
        });
    }

    private void loadUrl(String link, ContentAdapter.ViewHolder holder) {
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, desc;
        LinearLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.post_image);
            title = itemView.findViewById(R.id.post_title);
            desc = itemView.findViewById(R.id.post_desc);
            layout = itemView.findViewById(R.id.postLayoutItem);
        }
    }
}
