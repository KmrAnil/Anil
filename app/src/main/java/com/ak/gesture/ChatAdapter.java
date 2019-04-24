package com.ak.gesture;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    public static final int LEFT_SIDE =0;
    public static final int RIGHT_SIDE =1;
    public static final int CENTRE =2;
    private Context context;
    private List<data> listadapter;
    String hint;

    public ChatAdapter(Context context, List<data> listadapter) {
        this.context = context;
        this.listadapter = listadapter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType ==RIGHT_SIDE){
            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_right, parent, false);
            return new ViewHolder(view);

        }else if(viewType == CENTRE){
            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_centre, parent, false);
            return new ViewHolder(view);
        }

        else {
            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_left, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.showMsg.setText(listadapter.get(position).getMsg());
        if(!listadapter.get(position).imgurl.equals(null)){
            Glide.with(context).load(listadapter.get(position).getImgurl()).into(holder.showImage);
        }else {
            holder.showImage.setImageDrawable(null);
        }
    }
    @Override
    public int getItemCount() {
        return listadapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        public TextView showMsg;
        public ImageView showImage;
        public ViewHolder(View itemView) {
            super(itemView);
            showImage =itemView.findViewById(R.id.showImage);
            showMsg =itemView.findViewById(R.id.showMsg);
        }

        @Override
        public void onClick(View view) {

        }
    }

    @Override
    public int getItemViewType(int position) {
        hint = listadapter.get(position).getCount();
        if(hint.equals("0")){
            return LEFT_SIDE;
        }else if(hint.equals("2")){
            return CENTRE;
        }
        else{
            return RIGHT_SIDE;
        }
    }
}
