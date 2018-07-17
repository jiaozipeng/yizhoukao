package com.example.mylianxi_day0716.Presenter;

import com.example.mylianxi_day0716.BasePresenter;

/***

 **  项目名称：jiaozipeng20180716
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/16 21:14
 **  星期一


 **/
public interface IPresenter extends BasePresenter{
    void getList(String key,int page,Boolean refresh);
}
