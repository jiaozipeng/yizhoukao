package com.example.mylianxi_day0716.Presenter;

import android.view.View;

import com.example.mylianxi_day0716.MainActivity;
import com.example.mylianxi_day0716.Model.IShowBack;
import com.example.mylianxi_day0716.Model.IShowTask;
import com.example.mylianxi_day0716.Model.ShowBean;
import com.example.mylianxi_day0716.Model.ShowTack;
import com.example.mylianxi_day0716.View.IShowView;

import java.net.URLEncoder;

/***

 **  项目名称：jiaozipeng20180716
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/16 21:14
 **  星期一


 **/
public class Presenter implements IPresenter {

    IShowTask iShowTask;
    IShowView iShowView;

    public Presenter(MainActivity activity) {

        iShowTask =new ShowTack();
        this.iShowView =activity;

    }

    @Override
    public void getList(String key, final int page, final Boolean refresh) {
        //获取路径
        String url = "https://www.zhaoapi.cn/product/searchProducts?keywords=" + URLEncoder.encode(key) + "&page=" + page;

       iShowTask.getTask(url, new IShowBack() {
           @Override
           public void success(ShowBean data) {
               if(page==1){
                   if(refresh){
                       iShowView.refreshData(data.data);
                   }else{
                       iShowView.firstData(data.data);
                   }
               }else{
                   iShowView.moreData(data.data);
               }
           }

           @Override
           public void failed(String msg) {

           }
       });

    }

    @Override
    public void onDestroy() {
        iShowView= null;
    }
}
