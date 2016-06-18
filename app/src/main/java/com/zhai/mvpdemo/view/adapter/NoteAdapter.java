package com.zhai.mvpdemo.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zhai.mvpdemo.R;

import java.util.List;

/**
 * Created by zhai on 16/6/18.
 */

public class NoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list;
    private DeleteButtonListener listener;

    public NoteAdapter(List<String> list, DeleteButtonListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item, null, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tv.setText(list.get(position));
        viewHolder.bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDeleteButtonClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;
        public Button bn;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.content);
            bn = (Button) itemView.findViewById(R.id.remove);
        }
    }

    public interface DeleteButtonListener {
        void onDeleteButtonClick(int position);
    }
}
