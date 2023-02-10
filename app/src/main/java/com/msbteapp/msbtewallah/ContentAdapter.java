package com.msbteapp.msbtewallah;

import static android.content.Context.DOWNLOAD_SERVICE;
import static android.os.Environment.DIRECTORY_DOWNLOADS;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

    ArrayList<Item> list;
    Context context;

    public ContentAdapter(Context context, ArrayList<Item> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item model = list.get(position);
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());

        holder.shimmerFrameLayout.startShimmer();

        Glide.with(holder.imageView.getContext()).load(model.getImage()).into(holder.imageView);

        holder.shimmerFrameLayout.stopShimmer();
        holder.shimmerFrameLayout.setVisibility(View.GONE);

        holder.imageView.setVisibility(View.VISIBLE);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (model.getLink().contains("firebasestorage")){
                    Intent intent = new Intent(holder.cardView.getContext(), PdfView.class);
                    intent.putExtra("filename", model.getTitle());
                    intent.putExtra("fileurl", model.getLink());

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    holder.cardView.getContext().startActivity(intent);
                }else {
                    Uri uri = Uri.parse(model.getLink());
                    holder.cardView.getContext().startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
            }
        });

        holder.btnDownlaod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Downloading Started...", Toast.LENGTH_SHORT).show();
                if (model.getD_link().isEmpty() || model.getD_link().equals("null")){
                    downloadFile(holder.btnDownlaod.getContext(),model.getTitle(),".pdf",DIRECTORY_DOWNLOADS,model.getLink());
                }else{
                    downloadFile(holder.btnDownlaod.getContext(),model.getTitle(),".pdf",DIRECTORY_DOWNLOADS,model.getD_link());
                }
            }
        });
    }

    public void downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {

        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        downloadmanager.enqueue(request);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShimmerFrameLayout shimmerFrameLayout;

        ImageView imageView;
        TextView title, desc;
        CardView cardView;
        Button btnDownlaod;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            shimmerFrameLayout = itemView.findViewById(R.id.content_imageShimmer);

            imageView = itemView.findViewById(R.id.content_image);
            title = itemView.findViewById(R.id.content_title);
            desc = itemView.findViewById(R.id.content_desc);
            cardView = itemView.findViewById(R.id.cardViewItem);
            btnDownlaod = itemView.findViewById(R.id.download_btn);
        }
    }
}
