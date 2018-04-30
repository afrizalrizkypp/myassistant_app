package com.example.aldiros.coba_firebase.adapter;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.aldiros.coba_firebase.R;
import com.example.aldiros.coba_firebase.activity.DetailJobActivity;
import com.example.aldiros.coba_firebase.model.babysitterUser;
import com.example.aldiros.coba_firebase.model.bodyguardUser;
import com.example.aldiros.coba_firebase.model.bookingModel;
import com.example.aldiros.coba_firebase.model.driverUser;
import com.example.aldiros.coba_firebase.model.pembantuUser;
import com.example.aldiros.coba_firebase.model.satpamUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {
    Context context;
    private DatabaseReference mUserDatabase;
    List<bookingModel> postList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView user_name;
        public TextView user_umur;
        public ImageView user_image;
        public LinearLayout llRow;

        public ViewHolder(View itemView) {
            super(itemView);
            user_name = (TextView) itemView.findViewById(R.id.nama);
            user_umur = (TextView) itemView.findViewById(R.id.umur);
            user_image = (ImageView) itemView.findViewById(R.id.image);
            llRow = (LinearLayout) itemView.findViewById(R.id.llRow);
        }
    }

    public BookingAdapter(Context context, List<bookingModel> postList) {
        this.context = context;
        this.postList = postList;
    }

    @Override
    public BookingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_history, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BookingAdapter.ViewHolder holder, int position) {
        final bookingModel post = postList.get(position);

        holder.user_name.setText(post.getNama()+" ("+post.getMenu().toUpperCase()+")");
        holder.user_umur.setText(post.getUmur());
        Glide.with(context).load(post.getImage()).into(holder.user_image);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }


}
