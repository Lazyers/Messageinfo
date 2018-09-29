package com.example.strive.messageinfo;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.strive.messageinfo.entity.Recommend;

import java.util.ArrayList;
import java.util.List;

public class RecommendRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Recommend> list = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    public void setData(List<Recommend> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
        Log.d(TAG, "setData: "+list.size());
    }

    private static final String TAG = "RecommendRecycleAdapter";
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView recommendHeadImage;
        TextView recommendName,recommendIntro;
        Button recommendFollow;
        public ViewHolder(View itemView) {
            super(itemView);
            recommendHeadImage = itemView.findViewById(R.id.recommend_headimg);
            recommendName = itemView.findViewById(R.id.recommend_name);
            recommendIntro = itemView.findViewById(R.id.recommend_intro);
            recommendFollow = itemView.findViewById(R.id.recommend_follow);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(
            @NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recommend_node_item_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.recommendName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postion = holder.getAdapterPosition();
                Toast.makeText(
                        parent.getContext(), "打开"+list.get(postion).getName()+"个人信息页面",
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.recommendHeadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postion = holder.getAdapterPosition();
                Toast.makeText(
                        parent.getContext(), "打开"+list.get(postion).getName()+"个人信息页面",
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.recommendIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postion = holder.getAdapterPosition();
                Toast.makeText(
                        parent.getContext(), "打开"+list.get(postion).getName()+"个人信息页面",
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.recommendFollow.setOnClickListener(new View.OnClickListener() {
            boolean flag = true;
            @Override
            public void onClick(View v) {
                if(flag){
                    holder.recommendFollow.setBackgroundColor(Color.BLUE);
                    holder.recommendFollow.setTextColor(Color.WHITE);
                    flag = false;
                }else{
                    holder.recommendFollow.setBackgroundColor(Color.WHITE);
                    holder.recommendFollow.setTextColor(Color.BLACK);
                    flag = true;
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int adapterpostion = holder.getAdapterPosition();
        if(onItemClickListener != null){
            holder.itemView.setOnClickListener(
                    new RecommendOnItemClickListener(adapterpostion,list.get(adapterpostion)));
        }
        ((ViewHolder)holder).recommendHeadImage.setBackgroundResource(list.get(position).getHeadImage());
        ((ViewHolder)holder).recommendName.setText(list.get(position).getName());
        ((ViewHolder)holder).recommendIntro.setText(list.get(position).getIntroduce());
        Log.d(TAG, "onBindViewHolder: ");
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+list.size());
        return list.size();
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position, Recommend data);
    }

    public class RecommendOnItemClickListener implements View.OnClickListener{
        private int position;
        private Recommend data;

        public RecommendOnItemClickListener(int position, Recommend recommend) {
            this.position = position;
            this.data = recommend;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v,position,data);
        }
    }

}
