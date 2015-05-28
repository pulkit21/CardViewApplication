package com.example.pulkit.cardviewapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

import javax.xml.transform.Transformer;

public class GitUserAdapter extends RecyclerView.Adapter<GitUserAdapter.ViewHolder> {

    List<User> users;
    Context mContext;

    public GitUserAdapter(Context mContext, List<User> userList) {
        users = userList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int parent) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_profile, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        User user = users.get(position);
        
        Picasso.with(mContext).load(user.avatar_url).resize(mContext.getResources().getDisplayMetrics().heightPixels, mContext.getResources().getDisplayMetrics().widthPixels).into(viewHolder.userImage);
        viewHolder.userName.setText(user.login);
    }

    @Override
    public int getItemCount() {
        return (users != null ? users.size() : 0);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView userName;
        public ImageView userImage;

        public ViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.userName);
            userImage = (ImageView)itemView.findViewById(R.id.userImage);

        }
    }
}