package com.hsd.fsxasm.activity;import java.util.Set;import android.view.View;import com.hsd.fsxasm.R;import com.hsd.fsxasm.base.BaseActivity;import com.hsd.fsxasm.domain.HeartBeatBean;import com.hsd.fsxasm.engine.NHeartBeat;import com.hsd.fsxasm.widget.MPullToRefreshListView;public class LikeListsActivity extends BaseActivity{	private MPullToRefreshListView listView;			@Override	protected void initData() {		// TODO Auto-generated method stub		NHeartBeat nHeartBeat = new NHeartBeat(mActivity, new HttpResponseHandler());		nHeartBeat.getHeartBeatList();	}	@Override	protected View initView() {		View parents = View.inflate(mActivity, R.layout.like_list, null);		listView = (MPullToRefreshListView) parents.findViewById(R.id.id_foufri_list);		return parents;	}	@Override	protected void updataUI(Object obj) {		// TODO Auto-generated method stub		HeartBeatBean bean = (HeartBeatBean) obj;		Set<Integer> set = bean.getByHeartBeatUserIDSet();	}	@Override	protected void setListener() {		// TODO Auto-generated method stub			}}