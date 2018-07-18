package com.example.mydome_day0717.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mydome_day0717.R;

import java.util.List;

/***

 **  项目名称：jiaozipeng20180716
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/17 21:08
 **  星期二


 **/
 public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.ArrayHolder>{

    private Context context;
    private List<String>list;

    public ArrayAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ArrayHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ArrayHolder(View.inflate(context,R.layout.arrayadapter,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ArrayHolder arrayHolder, int i) {
        arrayHolder.textview.setText(list.get(i));

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class ArrayHolder extends RecyclerView.ViewHolder{

        TextView textview;

        public ArrayHolder(@NonNull View itemView) {
            super(itemView);
            textview= itemView.findViewById(R.id.textview);        }
    }
}
