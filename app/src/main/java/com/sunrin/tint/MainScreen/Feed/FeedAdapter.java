package com.sunrin.tint.MainScreen.Feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sunrin.tint.Model.PostModel;
import com.sunrin.tint.R;
import com.sunrin.tint.Util.DateUtil;
import com.sunrin.tint.Util.FirebaseLoadPost;

import java.util.ArrayList;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ItemViewHolder> {

    Context mContext;
    private List<PostModel> mData;

    FeedAdapter() {
        this.mData = new ArrayList<>();
    }

    FeedAdapter(List<PostModel> list) {
        this.mData = list;
    }

    public void setList(List<PostModel> list) {
        this.mData = list;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.feed_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        // Bind Data Here
        // TODO: apply animation to views here
        // https://youtu.be/rJ-7KgMAJUo

        PostModel item = mData.get(position);

        if (!item.getId().isEmpty()) {
            Glide.with(holder.feed_img)
                    .load(item.getImages().get(0))
                    .into(holder.feed_img);
        }
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());
        holder.timeInterval.setText(DateUtil.getTimeAgo(item.getDate(), mContext.getResources()));
        holder.userName.setText(item.getUserName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    //*****//
    public interface OnItemClickListener {
        void OnItemClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.itemClickListener = mListener;
    }

    private OnItemClickListener itemClickListener;

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView feed_img;
        ImageView userProfile;
        ImageButton commentBtn, shareBtn, storageBoxBtn;
        TextView title, subTitle, timeInterval, userName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            feed_img = itemView.findViewById(R.id.feed_img);
            userProfile = itemView.findViewById(R.id.feed_userProfile);
            shareBtn = itemView.findViewById(R.id.feed_share);
            commentBtn = itemView.findViewById(R.id.feed_comment);
            storageBoxBtn = itemView.findViewById(R.id.feed_storageBox);
            title = itemView.findViewById(R.id.feed_title);
            subTitle = itemView.findViewById(R.id.feed_subTitle);
            timeInterval = itemView.findViewById(R.id.feed_timeInterval);
            userName = itemView.findViewById(R.id.feed_userName);

            //*** Button Listener Setting ***//
            shareBtn.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    if (itemClickListener != null) {
                        // 아이템 클릭
                        itemClickListener.OnItemClick(v, pos);
                    }
                }
            });
            commentBtn.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    if (itemClickListener != null) {
                        itemClickListener.OnItemClick(v, pos);
                    }
                }
            });
            storageBoxBtn.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    if (itemClickListener != null) {
                        itemClickListener.OnItemClick(v, pos);
                    }
                }
            });
            feed_img.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    if (itemClickListener != null)
                        itemClickListener.OnItemClick(v, pos);
                }
            });
        }
    }
}
