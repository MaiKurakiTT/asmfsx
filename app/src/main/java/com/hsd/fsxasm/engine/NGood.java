package com.hsd.fsxasm.engine;import org.xutils.x;import org.xutils.common.Callback.CancelledException;import org.xutils.common.Callback.CommonCallback;import android.app.Activity;import android.os.Handler;import android.os.Message;import com.hsd.fsxasm.base.BaseCommonCallback;import com.hsd.fsxasm.base.BaseEngine;import com.hsd.fsxasm.domain.FindFriendsBean;import com.hsd.fsxasm.global.Constructs;import com.hsd.fsxasm.params.GoodParams;import com.hsd.fsxasm.utils.LogUtil;public class NGood extends BaseEngine{		private CommonCallback<String> callback;	private String TAG = "NGood";	public NGood(Activity mActivity,CommonCallback callback) {		// TODO Auto-generated constructor stub		super(mActivity);		this.callback = callback;	}			public NGood(Activity mActivity, Handler handler) {		super(mActivity, handler);		// TODO Auto-generated constructor stub	}	public void addGood(Integer friendCircle_id){		GoodParams params = new GoodParams(friendCircle_id);				if(!checkNet()){			LogUtil.info("NFindFriends", "网络有问题");			return;		}else{			x.http().post(params, callback);		}			}}