package com.hsd.fsxasm.engine;import java.io.IOException;import java.util.Iterator;import java.util.Set;import org.xutils.DbManager;import org.xutils.x;import org.xutils.ex.DbException;import android.app.Activity;import android.os.Handler;import android.os.Message;import com.hsd.fsxasm.base.BaseCommonCallback;import com.hsd.fsxasm.base.BaseEngine;import com.hsd.fsxasm.db.MDbUser;import com.hsd.fsxasm.db.MDbUtils;import com.hsd.fsxasm.domain.HeartBeatBean;import com.hsd.fsxasm.domain.LoginBean;import com.hsd.fsxasm.domain.UserInformationBean;import com.hsd.fsxasm.global.Constructs;import com.hsd.fsxasm.params.HeartBeatLISTParams;import com.hsd.fsxasm.params.LoginParams;import com.hsd.fsxasm.utils.LogUtil;public class NHeartBeatLIST extends BaseEngine{	public NHeartBeatLIST(Activity mActivity, Handler handler) {		super(mActivity, handler);		// TODO Auto-generated constructor stub	}	public void getHeartBeatList(Activity activity, Handler handler){		final Handler handler2 = handler;		final Activity activity2 = activity;		HeartBeatLISTParams params = new HeartBeatLISTParams();		if(!checkNet()){			return;		}else{			BaseCommonCallback<HeartBeatBean> baseCommonCallback = new BaseCommonCallback<HeartBeatBean>(mHandler){				@Override				public void onSuccess(HeartBeatBean bean) {					Set<Integer> heartBeatUserIDSet = bean.getHeartBeatUserIDSet();					Iterator<Integer> iterator = heartBeatUserIDSet.iterator();					int heartBeatCount = bean.getHeartBeatCount().intValue();					for(int i=0;i<heartBeatCount;i++){						Integer next = iterator.next();						System.out.println(next);						NGetUserIno getUserIno = new NGetUserIno(activity2, handler2);						getUserIno.getUserInfo(next, heartBeatCount);					}				}			};			x.http().post(params, baseCommonCallback);		}		}	}