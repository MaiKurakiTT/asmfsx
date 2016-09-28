package com.hsd.fsxasm.activity;

import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.hsd.fsxasm.R;
import com.hsd.fsxasm.adapter.DoctorAdapter;
import com.hsd.fsxasm.adapter.FriendCircleAdapter;
import com.hsd.fsxasm.base.BaseActivity;
import com.hsd.fsxasm.base.BaseFragment;
import com.hsd.fsxasm.domain.FriendCircleBean;
import com.hsd.fsxasm.engine.NFriendCircle;
import com.hsd.fsxasm.global.TempInfo;
import com.hsd.fsxasm.utils.LogUtil;
import com.hsd.fsxasm.widget.MPullToRefreshListView;
import com.hsd.fsxasm.widget.PopWindow;
import com.hsd.fsxasm.widget.SegmentView;
import com.hsd.fsxasm.widget.SignPopupWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 16/9/22.
 */
public class DoctorActivity extends BaseActivity{



    private MPullToRefreshListView listView;

    private FriendCircleAdapter.Holder holder;

    private PopWindow popwindow;
    private PopupWindow popupwindow;

    private ArrayList<Boolean> temps;


    // TODO
    private List<FriendCircleBean> beans;

    private DoctorAdapter adapter;

    private SegmentView segmentView;

    private SignPopupWindow signPopupWindow;

    @Override
    protected void initData() {
        // TODO Auto-generated method stub
        mTitle.setVisibility(View.GONE);
        mHelp.setVisibility(View.VISIBLE);
        mHelp.setText("发布");

        // TODO
        NFriendCircle circle = new NFriendCircle(mActivity, new BaseActivity.HttpResponseHandler());
        circle.friendCircle(TempInfo.findFirst.getUuid(), 1, 20);
    }

    @Override
    protected View initView() {
        // TODO Auto-generated method stub
        View parents = View.inflate(mActivity, R.layout.il_friendcircle, null);
        signPopupWindow = new SignPopupWindow(mActivity);
        listView = (MPullToRefreshListView) parents.findViewById(R.id.ii_pull_flush_listview);
        popupwindow = new PopupWindow(mActivity);
        return parents;
    }

    @Override
    protected void updataUI(Object obj) {
        // TODO Auto-generated method stub
        FriendCircleBean bean = (FriendCircleBean) obj;
        String result = bean.getBody();
        //System.out.println(result);
        JSONArray jsonArray = new JSONArray();
        beans = jsonArray.parseArray(result, FriendCircleBean.class);
        //beans = JSONArray.parseArray(result, FriendCircleBean.class);
        adapter = new DoctorAdapter(mActivity, beans);
        listView.setAdapter(adapter);
        //Utility.setListViewHeightBasedOnChildren(listView.getRefreshableView());
    }

    @Override
    protected void setListener() {
        mHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.info("点击了发布按钮");
            }
        });
    }
}
