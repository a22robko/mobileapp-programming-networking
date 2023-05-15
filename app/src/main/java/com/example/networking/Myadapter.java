package com.example.networking;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {

    private List<Mountain> mountains;
    private OnClickListener onClickListener;

    public Myadapter(List<Mountain> mountains, OnClickListener onClickListener) {
        this.mountains = mountains;
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(Mountain mountain);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(mountains.get(getAdapterPosition()));
        }
    }

    @Override
    public Myadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mountain, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mountains.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }
}