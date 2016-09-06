package com.hsd.fsxasm;import org.xutils.x;import cn.smssdk.SMSSDK;import com.hsd.fsxasm.activity.FlashActivity;import com.hsd.fsxasm.activity.GuideActivity;import com.hsd.fsxasm.activity.MainFragmentActivity;import com.hsd.fsxasm.activity.RegisterAndLoginActivity;import com.hsd.fsxasm.chat.DemoHelper;import com.hsd.fsxasm.chat.manager.PreferenceManager;import com.hsd.fsxasm.db.MDbUser;import com.hsd.fsxasm.db.MDbUtils;import com.hsd.fsxasm.fragment.HomeFragment;import com.hsd.fsxasm.global.SharedPreferencesString;import com.hsd.fsxasm.global.TempInfo;import com.hsd.fsxasm.utils.AsyncImageLoader;import com.hsd.fsxasm.utils.LogUtil;import com.hsd.fsxasm.utils.PrefUtils;import com.hyphenate.EMCallBack;import com.hyphenate.chat.EMClient;import com.hyphenate.chat.EMOptions;import com.hyphenate.easeui.controller.EaseUI;import com.hyphenate.easeui.controller.EaseUI.EaseUserProfileProvider;import com.hyphenate.easeui.domain.EaseUser;import com.umeng.comm.core.CommunitySDK;import com.umeng.comm.core.impl.CommunityFactory;import android.app.Activity;import android.content.Context;import android.content.Intent;import android.content.SharedPreferences;import android.os.Bundle;import android.support.multidex.MultiDex;import android.util.Log;import android.view.Menu;import android.view.MenuItem;public class MainActivity extends Activity {	protected SharedPreferences sp;	public static Context mContext;	@Override	protected void onCreate(Bundle savedInstanceState) {		super.onCreate(savedInstanceState);		sp = getSharedPreferences("init", Context.MODE_PRIVATE);		mContext = getApplicationContext();		x.Ext.init(getApplication());		//微社区注册		CommunitySDK mCommSDK = CommunityFactory.getCommSDK(this);		mCommSDK.initSDK(this);		SMSSDK.initSDK(getApplicationContext(), "d96cb7907b14",				"aa2eccfa4da5d9869dabd6335490a6a0");		init();		if (sp.getBoolean(SharedPreferencesString.IS_LOGIN, false)) {			TempInfo.init(this,					sp.getString(SharedPreferencesString.CURRENT_USER, ""));			// Intent intent = new			// Intent(MainActivity.this,FlashActivity.class);			// \\ startActivity(intent);			loginChat();		} else {			boolean flag = PrefUtils.getBoolean(this, "is_user_guide_showed",					true);			if (flag) {				Intent intent = new Intent(this, GuideActivity.class);				startActivity(intent);			} else {				Intent intent = new Intent(this, FlashActivity.class);				startActivity(intent);			}			finish();		}		// Intent intent = new Intent(this,MainFragmentActivity.class);		// startActivity(intent);	}	private void initUserNameAndPic() {		// TODO Auto-generated method stub/*		EaseUI.getInstance().setUserProfileProvider(				new EaseUserProfileProvider() {					@Override					public EaseUser getUser(String username) {						// TODO Auto-generated method stub						EaseUser user = new EaseUser(username);						user.setAvatar("http://pic32.nipic.com/20130829/12906030_124355855000_2.png");						user.setNick("小明1号");						return user;					}				});*/	}	private void init() {		// TODO Auto-generated method stub		LogUtil.info("context==null?", getApplicationContext() == null ? "ssss"				: "1111");		DemoHelper.getInstance().init(getApplicationContext());	}	void loginChat() {		System.out.println(TempInfo.findFirst.getUser_id() + "=======");		EMClient.getInstance().login(TempInfo.findFirst.getUser_id() + "",				"123456", new EMCallBack() {					@Override					public void onSuccess() {						// TODO Auto-generated method stub						Log.i("123123", "登录成功");						Intent intent = new Intent(MainActivity.this,								FlashActivity.class);						startActivity(intent);						finish();					}					@Override					public void onProgress(int arg0, String arg1) {						// TODO Auto-generated method stub					}					@Override					public void onError(int arg0, String arg1) {						// TODO Auto-generated method stub						Log.i("123123", "登录失败");					}				});		DemoHelper.getInstance().init(this);		EMClient.getInstance().updateCurrentUserNick("");	}}