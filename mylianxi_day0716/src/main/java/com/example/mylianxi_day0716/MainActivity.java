package com.example.mylianxi_day0716;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mylianxi_day0716.Model.IShowTask;
import com.example.mylianxi_day0716.Model.Show;
import com.example.mylianxi_day0716.Model.ShowBean;
import com.example.mylianxi_day0716.Presenter.IPresenter;
import com.example.mylianxi_day0716.Presenter.Presenter;
import com.example.mylianxi_day0716.View.IShowView;
import com.example.mylianxi_day0716.View.MyAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IShowView{

    Presenter presenter;
    private  int page= 1;

    private PullToRefreshListView pull_listview;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pull_listview= findViewById(R.id.pull_listView);
        presenter = new Presenter(this);
        presenter.getList("笔记本",1,false);

        getData();
    }

    private void getData() {
        pull_listview.setMode(PullToRefreshListView.Mode.BOTH);
        pull_listview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                page=1;
                presenter.getList("笔记本",page,true);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {

                page++;
                presenter.getList("笔记本",page,false);
            }
        });

        //创建适配器
        myAdapter = new MyAdapter(MainActivity.this, new ArrayList<Show>());
        pull_listview.setAdapter(myAdapter);


    }

    @Override
    public void firstData(List<Show> list) {
        myAdapter.addData(list);
        pull_listview.onRefreshComplete();


    }

    @Override
    public void moreData(List<Show> list) {

        myAdapter.addData(list);
        pull_listview.onRefreshComplete();
    }

    @Override
    public void refreshData(List<Show> list) {
        myAdapter.clearData();
        myAdapter.addData(list);
        pull_listview.onRefreshComplete();

    }

    @Override
    public void setPresenter(BasePresenter presenters) {

       //this.presenter = presenters;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
