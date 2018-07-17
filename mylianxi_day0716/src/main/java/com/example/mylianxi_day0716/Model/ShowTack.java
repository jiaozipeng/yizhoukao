package com.example.mylianxi_day0716.Model;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mylianxi_day0716.Application.Myapplication;
import com.google.gson.Gson;

/***

 **  项目名称：jiaozipeng20180716
 ** 创建人：jiaozipeng
 ** 创建时间：2018/7/16 21:08
 **  星期一


 **/
public class ShowTack implements IShowTask {
    @Override
    public void getTask(String url, final IShowBack iShowBack) {


        RequestQueue queue = Volley.newRequestQueue(Myapplication.context);

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                ShowBean showBean = gson.fromJson(response, ShowBean.class);
                iShowBack.success(showBean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                iShowBack.failed(error.getMessage());
            }
        });
        queue.add(request);
    }
}
