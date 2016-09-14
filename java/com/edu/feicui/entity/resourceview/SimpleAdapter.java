package com.edu.feicui.entity.resourceview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/13.
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.DemoViewHodler> {
    private final ArrayList<String> datas = new ArrayList<>();

    public void clear() {
        datas.clear();
    }

    public void addItem(String data) {
        datas.add(data);
    }

    @Override
    public DemoViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_text, parent, false);
        return new DemoViewHodler(view);
    }

    @Override
    public void onBindViewHolder(DemoViewHodler holder, int position) {
        final String data = datas.get(position);
        holder.textView.setText(data);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), data, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class DemoViewHodler extends RecyclerView.ViewHolder {
        @Bind(R.id.textView)
        TextView textView;

        public DemoViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
