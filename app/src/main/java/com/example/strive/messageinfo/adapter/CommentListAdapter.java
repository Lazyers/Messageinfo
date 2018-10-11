package com.example.strive.messageinfo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.strive.messageinfo.R;
import com.example.strive.messageinfo.entity.CommentInfo;

import java.util.ArrayList;
import java.util.List;

public class CommentListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<CommentInfo> list = new ArrayList<>();
    public void setData(List<CommentInfo> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView commentHead;
        TextView commentName,commentDate,commentContent;
        Button commentLike;
        public ViewHolder(View itemView) {
            super(itemView);
            commentHead = itemView.findViewById(R.id.commentHead);
            commentName = itemView.findViewById(R.id.commentName);
            commentDate = itemView.findViewById(R.id.commentDate);
            commentLike = itemView.findViewById(R.id.commentLike);
            commentContent = itemView.findViewById(R.id.commentContent);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).commentHead.setImageResource(list.get(position).getImageURL());
        ((ViewHolder)holder).commentName.setText(list.get(position).getName());
        ((ViewHolder)holder).commentDate.setText(list.get(position).getDate());
        ((ViewHolder)holder).commentContent.setText(list.get(position).getComtent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
