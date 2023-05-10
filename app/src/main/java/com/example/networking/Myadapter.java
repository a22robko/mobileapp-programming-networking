package com.example.networking;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.networking.RecyclerItem;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {

    private List<RecyclerItem> items;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;

    public Myadapter(Context context, List<RecyclerItem> items, OnClickListener onClickListener) {
        this.items = items;
        this.layoutInflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_mountain, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.name);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(items.get(getAdapterPosition()));

        }
    }

    public interface OnClickListener {
        void onClick(RecyclerItem item);

    }
}