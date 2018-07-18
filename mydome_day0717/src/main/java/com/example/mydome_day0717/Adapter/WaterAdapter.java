package com.example.mydome_day0717.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mydome_day0717.R;

import java.util.ArrayList;
import java.util.List;

/***

 **  项目名称：jiaozipeng20180716
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/18 14:33
 **  星期三


 **/
public class WaterAdapter extends RecyclerView.Adapter<WaterAdapter.waterholder>{

    private Context context;
    private List<String> list;
    private List<Integer> heights = new ArrayList<>();

    public WaterAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        for (int i = 0; i < list.size(); i++) {
            heights.add((int) (Math.random()*500+150));
        }
    }

    @NonNull
    @Override
    public waterholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new waterholder(View.inflate(context,R.layout.wateradapter,null));
    }

    @Override
    public void onBindViewHolder(@NonNull waterholder waterholder, int i) {

        ViewGroup.LayoutParams layoutParams = waterholder.watertext.getLayoutParams();

        layoutParams.height= heights.get(i);
        waterholder.watertext.setBackgroundColor(Color.rgb((int) (Math.random() * 180 + 155),(int) (Math.random() * 180 + 155), (int) (Math.random() * 180 + 155)));

        waterholder.watertext.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class waterholder extends RecyclerView.ViewHolder{

        TextView watertext;
        public waterholder(@NonNull View itemView) {
            super(itemView);
            watertext= itemView.findViewById(R.id.watertext);
        }
    }
}
