package com.hsd.fsxasm.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hsd.fsxasm.R;
import com.hsd.fsxasm.mvp.adapter.HeartBeatListAdapter;
import com.hsd.fsxasm.mvp.bean.UserInformationBean;
import com.hsd.fsxasm.mvp.contract.RequestHeartBeatContract;
import com.hsd.fsxasm.mvp.presenter.RequestHeartBeatPresenter;

import java.util.List;

/**
 * Created by apple on 16/10/7.
 */

public class HeartBeatListActivity extends AppCompatActivity implements RequestHeartBeatContract.View{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heart_beat_list);
        recyclerView = (RecyclerView) findViewById(R.id.hb_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RequestHeartBeatPresenter heartBeatPresenter = new RequestHeartBeatPresenter(this);
        heartBeatPresenter.getData();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showData(List<UserInformationBean> userInformation) {
        HeartBeatListAdapter adapter = new HeartBeatListAdapter(this, userInformation);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showFailed() {

    }
}
