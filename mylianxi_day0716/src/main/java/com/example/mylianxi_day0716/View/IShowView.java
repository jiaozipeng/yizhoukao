package com.example.mylianxi_day0716.View;

import com.example.mylianxi_day0716.BasePresenter;
import com.example.mylianxi_day0716.BaseView;
import com.example.mylianxi_day0716.Model.Show;
import com.example.mylianxi_day0716.Model.ShowBean;

import java.util.List;

/***

 **  项目名称：jiaozipeng20180716
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/16 21:19
 **  星期一


 **/
public interface IShowView extends BaseView<BasePresenter>{


    void firstData(List<Show> list);
    void moreData(List<Show> list);
    void refreshData(List<Show> list);
}
