package com.example.mylianxi_day0716.View;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylianxi_day0716.Application.Myapplication;
import com.example.mylianxi_day0716.Model.Show;
import com.example.mylianxi_day0716.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/***

 **  项目名称：jiaozipeng20180716
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/16 21:20
 **  星期一


 **/
public class MyAdapter extends BaseAdapter{

    private Context context;
    private List<Show>list;

    public MyAdapter(Context context, List<Show> list) {
        this.context = context;
        this.list = list;
    }

    public void addData(List<Show> shows){
        list.addAll(shows);
        notifyDataSetChanged();
    }
    public void clearData(){
        list.clear();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Show getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewholder holder;
        if(view==null){
            view= View.inflate(context, R.layout.mybase,null);
            holder= new viewholder();
            holder.text = view.findViewById(R.id.text);
            holder.image= view.findViewById(R.id.image);
            view.setTag(holder);

        }else{
            holder= (viewholder) view.getTag();
        }
        holder.text.setText(getItem(i).title);
        ImageLoader.getInstance().displayImage(list.get(i).getImages(),holder.image, Myapplication.getoptions());
        return view;
    }
    class viewholder{
        TextView text;
        ImageView image;
    }
}
