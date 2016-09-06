package com.hsd.fsxasm.activity;import java.util.List;import org.xutils.DbManager;import org.xutils.x;import org.xutils.db.Selector;import org.xutils.ex.BaseException;import org.xutils.ex.DbException;import org.xutils.view.annotation.Event;import org.xutils.view.annotation.ViewInject;import android.content.Intent;import android.os.Bundle;import android.os.Handler;import android.view.View;import android.view.Window;import android.view.WindowManager;import android.widget.Button;import android.widget.Toast;import com.hsd.fsxasm.R;import com.hsd.fsxasm.base.BaseActivity;import com.hsd.fsxasm.db.MDbUser;import com.hsd.fsxasm.db.MDbUtils;import com.hsd.fsxasm.domain.FindFriendsBean;import com.hsd.fsxasm.domain.LoginBean;import com.hsd.fsxasm.domain.TestBean;import com.hsd.fsxasm.engine.NFindFriends;import com.hsd.fsxasm.engine.NLogin;import com.hsd.fsxasm.engine.NTest;import com.hsd.fsxasm.global.SharedPreferencesString;import com.hsd.fsxasm.utils.LogUtil;public class FlashActivity extends BaseActivity {		@Override	protected View initView() {		mRootView = View.inflate(this, R.layout.activity_main, null);		return mRootView;	}	@Override	protected void updataUI(Object obj) {		LoginBean loginBean = (LoginBean) obj;		LogUtil.info("FlashActivity", "updataUI成功");	}	@Override	protected void setListener() {		// TODO Auto-generated method stub	}	@Override	protected void initData() {		boolean flag = sp.getBoolean(SharedPreferencesString.IS_LOGIN, false);		if (flag) {			new Handler().postDelayed(new Runnable() {				@Override				public void run() {					Intent intent = new Intent(FlashActivity.this, MainFragmentActivity.class);					startActivity(intent);					finish();				}			}, 1000);		} else {			Intent intent = new Intent(this, RegisterAndLoginActivity.class);			startActivity(intent);			finish();		}	}}