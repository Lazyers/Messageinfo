package com.example.strive.messageinfo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.strive.messageinfo.R;
import com.example.strive.messageinfo.entity.Node;
import com.example.strive.messageinfo.entity.Status;
import com.example.strive.messageinfo.ui.PersonAllInformationActivity;
import com.example.strive.messageinfo.ui.UserWindow;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter< RecyclerView.ViewHolder> {

    private List<Node> list = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    private Activity activity;
    RecommendRecycleAdapter adapter;
    private boolean flag = true;

    private static final int NORMAL = 1;
    private static final int RECOMMEND = 2;
    private static final int FOOT_VIEW = 3;

    private static final int NOMORE = 1;
    private static final int ISLOADING = 2;
    int footstat = 0;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void clear(){
        list.clear();
        notifyDataSetChanged();
    }

    public MessageAdapter(Activity activity) {
        this.activity = activity;
    }

    public void setList(List<Node> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, date, type, content, pl, dz, zf;
        Button comment, like, share,flow;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.headimg);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            type = itemView.findViewById(R.id.type);
            content = itemView.findViewById(R.id.contenttx);
            pl = itemView.findViewById(R.id.pl);
            dz = itemView.findViewById(R.id.dz);
            zf = itemView.findViewById(R.id.zf);
            comment = itemView.findViewById(R.id.plb);
            like = itemView.findViewById(R.id.dzb);
            share = itemView.findViewById(R.id.zfb);
            flow = itemView.findViewById(R.id.flow);
        }
    }
    class RecommendViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        public RecommendViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recomment_recycle);
        }
    }
    class FootViewHolder extends RecyclerView.ViewHolder{
        TextView footView;
        public FootViewHolder(View itemView) {
            super(itemView);
            footView = itemView.findViewById(R.id.footview);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == getItemCount()-1){
            return FOOT_VIEW;
        }else if (list.get(position).getRecommendList() == null) {
            return NORMAL;
        }
        return RECOMMEND;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == NORMAL) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.normal_node_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);

            holder.flow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    Intent intent = new Intent(activity,UserWindow.class);
                    Status status = list.get(position).getStatus();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("status",status);
                    intent.putExtras(bundle);
                    intent.putExtra("name",list.get(position).getName());
                    activity.startActivity(intent);
                }
            });
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    Toast.makeText(activity, "打开" + list.get(position).getName() + "的个人信息页面",
                            Toast.LENGTH_SHORT).show();
                }
            });
            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    Toast.makeText(activity, "打开" + list.get(position).getName() + "的个人信息页面",
                            Toast.LENGTH_SHORT).show();
                }
            });
            holder.type.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    Toast.makeText(activity, "打开" + list.get(position).getType() + "页面",
                            Toast.LENGTH_SHORT).show();
                }
            });
            holder.share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    Toast.makeText(activity, "打开转发页面",
                            Toast.LENGTH_SHORT).show();
                }
            });
            holder.zf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    Toast.makeText(activity, "打开转发页面",
                            Toast.LENGTH_SHORT).show();
                }
            });
            holder.dz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    if (flag) {
                        holder.like.setBackgroundColor(Color.BLUE);
                        flag = false;
                        list.get(position).setLike(list.get(position).getLike() + 1);
                        notifyDataSetChanged();
                    } else {
                        holder.like.setBackgroundColor(Color.BLACK);
                        flag = true;
                        list.get(position).setLike(list.get(position).getLike() - 1);
                        notifyDataSetChanged();
                    }
                }
            });
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    Intent intent = new Intent(activity,PersonAllInformationActivity.class);
                    Bundle bundle = new Bundle();
                    Node node = list.get(position);

                    bundle.putSerializable("node",node);
                    intent.putExtras(bundle);
                    intent.putExtra("flag",flag);
                    activity.startActivity(intent);
                }
            });
            return holder;
        } else if(viewType == RECOMMEND){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recommend_node_item,parent,false);
            RecommendViewHolder holder = new RecommendViewHolder(view);
            holder.recyclerView.setLayoutManager(
                    new LinearLayoutManager(
                            parent.getContext(),
                            LinearLayoutManager.HORIZONTAL,
                            false));
            return holder;
        }else{
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.foot_view_node_item,parent,false);
            FootViewHolder holder = new FootViewHolder(view);
            return holder;
        }
    }
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == NORMAL) {
            int adapterPostion = holder.getAdapterPosition();
            if (onItemClickListener != null) {
                holder.itemView.setOnClickListener(
                        new MyOnItemClickListener(position, list.get(adapterPostion)));
            }
            Node node = list.get(position);
            ((MessageAdapter.ViewHolder)holder).imageView.setBackgroundResource(node.getImageURL());
            ((MessageAdapter.ViewHolder)holder).name.setText(node.getName());
            ((MessageAdapter.ViewHolder)holder).date.setText(node.getData());
            ((MessageAdapter.ViewHolder)holder).type.setText(node.getType());
            ((MessageAdapter.ViewHolder)holder).content.setText(node.getContent());
            ((MessageAdapter.ViewHolder)holder).dz.setText(node.getLike() + "");
        } else if(getItemViewType(position) == RECOMMEND){
            adapter = new RecommendRecycleAdapter();
            adapter.setData(list.get(position).getRecommendList());
            ((RecommendViewHolder)holder).recyclerView.setAdapter(adapter);
        }else{
            FootViewHolder footViewHolder = (FootViewHolder) holder;
            if(position == 0){
                footViewHolder.footView.setText("");
            }
            switch (footstat){
                case NOMORE :
                    footViewHolder.footView.setText("没有更多");
                    break;
                case ISLOADING :
                    footViewHolder.footView.setText("");
                    break;
            }
        }
    }
    public void setFootstat(int footstat){
        this.footstat = footstat;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, Node data);
    }

    public class MyOnItemClickListener implements View.OnClickListener {
        private int position;
        private Node data;

        public MyOnItemClickListener(int position, Node data) {
            this.position = position;
            this.data = data;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v, position, data);
        }
    }
}
