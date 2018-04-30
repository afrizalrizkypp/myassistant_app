package com.example.aldiros.coba_firebase.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aldiros.coba_firebase.R;
import com.example.aldiros.coba_firebase.activity.DetailJobActivity;
import com.example.aldiros.coba_firebase.model.babysitterUser;
import com.example.aldiros.coba_firebase.model.bodyguardUser;

import java.util.List;

public class BodyguardAdapter extends RecyclerView.Adapter<BodyguardAdapter.ViewHolder> {
    Context context;
    List<bodyguardUser> postList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView user_name;
        public TextView user_umur;
        public TextView user_gaji;
        public ImageView user_image;
        public LinearLayout llRow;
        public TextView user_alamat;

        public ViewHolder(View itemView) {
            super(itemView);
            user_name = (TextView) itemView.findViewById(R.id.nama);
//            user_umur = (TextView) itemView.findViewById(R.id.umur);
            user_alamat = (TextView) itemView.findViewById(R.id.alamat);
            user_gaji = (TextView) itemView.findViewById(R.id.gaji);
            user_image = (ImageView) itemView.findViewById(R.id.image);
            llRow = (LinearLayout) itemView.findViewById(R.id.llRow);
        }
    }

    public BodyguardAdapter(Context context, List<bodyguardUser> postList) {
        this.context = context;
        this.postList = postList;
    }

    @Override
    public BodyguardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_babysitter, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BodyguardAdapter.ViewHolder holder, int position) {
        final bodyguardUser post = postList.get(position);

        holder.user_name.setText(post.getNama());
//        holder.user_umur.setText(post.getUmur());
        holder.user_alamat.setText(post.getAlamat());
        holder.user_gaji.setText(post.getGaji());
        Glide.with(context).load(post.getImage()).into(holder.user_image);

        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailJobActivity.class);
                i.putExtra("image", post.getImage());
                i.putExtra("nama", post.getNama());
                i.putExtra("umur", post.getUmur());
                i.putExtra("gaji", post.getGaji());
                i.putExtra("lokasi", post.getAlamat());
                i.putExtra("notelp", post.getPhone());
                i.putExtra("desc", post.getDeskripsi());
                i.putExtra("menu", "bodyguard");
                i.putExtra("key_menu", post.getKey_menu());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
