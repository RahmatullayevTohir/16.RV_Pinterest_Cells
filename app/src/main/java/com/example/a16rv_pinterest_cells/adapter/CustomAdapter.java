package com.example.a16rv_pinterest_cells.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a16rv_pinterest_cells.R;
import com.example.a16rv_pinterest_cells.model.User;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<User> users;

    public CustomAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = users.get(position);
        if (holder instanceof CustomViewHolder){
            if (position%2==0) {
                ((CustomViewHolder) holder).item_image.setImageResource(R.drawable.im_simple3);
            }
            if (position%3==0){
                ((CustomViewHolder)holder).item_image.setImageResource(R.drawable.im_simple1);
            }
            if (position %4 ==0){
                ((CustomViewHolder)holder).item_image.setImageResource(R.drawable.im_simpl2);
            }
            else {
                ((CustomViewHolder)holder).item_image.setImageResource(R.drawable.im_simple3);
            }
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public  class CustomViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ImageView item_image;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            item_image = view.findViewById(R.id.item_image);
        }
    }
}
