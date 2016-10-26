package com.lprecycleview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
    String[] strs = new String[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycleView = (RecyclerView) findViewById(R.id.rv_recycleview);
        for (int i = 0; i < 100; i++) {
            strs[i] = "item" + i;
        }
        recycleView.setLayoutManager(new LinearLayoutManager(this, OrientationHelper.VERTICAL, false));

        recycleView.setAdapter(new MyAdapter(this));
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        Context context;

        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.itemview, null);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv_textview.setText(strs[position]);

        }

        @Override
        public int getItemCount() {
            return strs.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView tv_textview;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv_textview = (TextView) itemView.findViewById(R.id.tv_textview);
            }
        }
    }
}
