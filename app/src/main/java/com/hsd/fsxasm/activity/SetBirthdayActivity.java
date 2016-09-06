package com.hsd.fsxasm.activity;import java.util.Calendar;import android.content.Intent;import android.view.View;import android.view.View.OnClickListener;import android.widget.PopupWindow;import android.widget.RelativeLayout;import android.widget.TextView;import com.hsd.fsxasm.R;import com.hsd.fsxasm.base.BaseActivity;import com.hsd.fsxasm.widget.wheelview.OnWheelScrollListener;import com.hsd.fsxasm.widget.wheelview.WheelView;import com.hsd.fsxasm.widget.wheelview.adapter.NumericWheelAdapter;public class SetBirthdayActivity extends BaseActivity {	private WheelView mViewProvince;	private WheelView mViewCity;	private WheelView mViewDistrict;	// private LayoutInflater inflater = null;	private WheelView year;	private WheelView month;	private WheelView day;	/*	 * private WheelView time; private WheelView min; private WheelView sec;	 */	private int mYear = 1996;	private int mMonth = 0;	private int mDay = 1;	View view = null;	private PopupWindow birthdayPopupWindow;	private TextView birthdayText;	private TextView constellationText;	private String birthday;	private String constellation;	private RelativeLayout birthdayChooseView;	@Override	protected View initView() {		View parent = View.inflate(this,				R.layout.il_setotherpersoninfo_setbirthday, null);		Intent intent = getIntent();		birthdayText = (TextView) parent				.findViewById(R.id.id_setotherpersoninfo_setbirthday_brithday);		constellationText = (TextView) parent				.findViewById(R.id.id_setotherpersoninfo_setbirthday_constellation);		birthdayText.setText(intent.getStringExtra("birthday"));		constellationText.setText(intent.getStringExtra("constellation"));		birthdayChooseView = (RelativeLayout) parent				.findViewById(R.id.il_setotherpersoninfo_setbirthday_choose);		birthdayChooseView.addView(getDataPick());		return parent;	}	/**	 * 关闭Activity并返回值	 */	private void finish1() {		birthday = birthdayText.getText().toString();		constellation = constellationText.getText().toString();		Intent intent = getIntent();		intent.putExtra("birthday", birthday);		intent.putExtra("constellation", constellation);		setResult(10, intent);		finish();	}	@Override	public void onBackPressed() {		birthday = birthdayText.getText().toString();		constellation = constellationText.getText().toString();		Intent intent = getIntent();		intent.putExtra("birthd123213ay", birthday);		intent.putExtra("constel1231321lation", constellation);		setResult(112321320, intent);		finish();		// super.onBackPressed();	}	@Override	protected void initData() {		mTitle.setText("设置生日");		mHelp.setText("完成");		mBack.setVisibility(View.VISIBLE);		mHelp.setVisibility(View.VISIBLE);	}	@Override	protected void updataUI(Object obj) {		// TODO Auto-generated method stub	}	@Override	protected void setListener() {		mBack.setOnClickListener(new OnClickListener() {			@Override			public void onClick(View v) {				birthday = birthdayText.getText().toString();				constellation = constellationText.getText().toString();				Intent intent = getIntent();				intent.putExtra("birthd123213ay", birthday);				intent.putExtra("constel1231321lation", constellation);				setResult(112321320, intent);				finish();			}		});		mHelp.setOnClickListener(new OnClickListener() {			@Override			public void onClick(View v) {				finish1();			}		});	}	/**	 * 获取时间选择器	 * 	 * @return	 */	private View getDataPick() {		Calendar c = Calendar.getInstance();		int norYear = c.get(Calendar.YEAR);		// int curMonth = c.get(Calendar.MONTH) + 1;//通过Calendar算出的月数要+1		// int curDate = c.get(Calendar.DATE);		int curYear = mYear;		int curMonth = mMonth + 1;		int curDate = mDay;		view = View.inflate(this, R.layout.wheel_date_picker, null);		// 初始化时间选择的确定按钮 并设置事件监听 来移除此时间选择器		year = (WheelView) view.findViewById(R.id.year);		NumericWheelAdapter numericWheelAdapter1 = new NumericWheelAdapter(				this, 1950, norYear);		numericWheelAdapter1.setLabel("年");		year.setViewAdapter(numericWheelAdapter1);		year.setCyclic(true);// 是否可循环滑动		year.addScrollingListener(scrollListener);		month = (WheelView) view.findViewById(R.id.month);		NumericWheelAdapter numericWheelAdapter2 = new NumericWheelAdapter(				this, 1, 12, "%02d");		numericWheelAdapter2.setLabel("月");		month.setViewAdapter(numericWheelAdapter2);		month.setCyclic(true);		month.addScrollingListener(scrollListener);		day = (WheelView) view.findViewById(R.id.day);		initDay(curYear, curMonth);		day.setCyclic(true);		day.addScrollingListener(scrollListener);		year.setVisibleItems(7);// 设置显示行数		month.setVisibleItems(7);		day.setVisibleItems(7);		year.setCurrentItem(curYear - 1950);		month.setCurrentItem(curMonth - 1);		day.setCurrentItem(curDate - 1);		return view;	}	OnWheelScrollListener scrollListener = new OnWheelScrollListener() {		@Override		public void onScrollingStarted(WheelView wheel) {		}		@Override		public void onScrollingFinished(WheelView wheel) {			int n_year = year.getCurrentItem() + 1950;// 年			int n_month = month.getCurrentItem() + 1;// 月			initDay(n_year, n_month);			birthday = new StringBuilder()					.append((year.getCurrentItem() + 1950))					.append("-")					.append((month.getCurrentItem() + 1) < 10 ? "0"							+ (month.getCurrentItem() + 1) : (month							.getCurrentItem() + 1))					.append("-")					.append(((day.getCurrentItem() + 1) < 10) ? "0"							+ (day.getCurrentItem() + 1) : (day							.getCurrentItem() + 1)).toString();			// Toast.makeText(SettingBirthdayOfSettingOtherPersonInfo.this,			// birthday, 0).show();			birthdayText.setText(birthday.toString());			constellation = getAstro(month.getCurrentItem() + 1,					day.getCurrentItem() + 1);			constellationText.setText(constellation);		}	};	/**	 * 	 * @param year	 * @param month	 * @return	 */	private int getDay(int year, int month) {		int day = 30;		boolean flag = false;		switch (year % 4) {		case 0:			flag = true;			break;		default:			flag = false;			break;		}		switch (month) {		case 1:		case 3:		case 5:		case 7:		case 8:		case 10:		case 12:			day = 31;			break;		case 2:			day = flag ? 29 : 28;			break;		default:			day = 30;			break;		}		return day;	}	/**	 * 初始化时间	 * 	 * @param arg1	 * @param arg2	 */	private void initDay(int arg1, int arg2) {		NumericWheelAdapter numericWheelAdapter = new NumericWheelAdapter(this,				1, getDay(arg1, arg2), "%02d");		numericWheelAdapter.setLabel("日");		day.setViewAdapter(numericWheelAdapter);	}	/**	 * 根据日期计算年龄	 * 	 * @param birthday	 * @return	 */	/*	 * public static final String calculateDatePoor(String birthday) { try { if	 * (TextUtils.isEmpty(birthday)) return "0"; SimpleDateFormat sdf = new	 * SimpleDateFormat("yyyy-MM-dd"); Date birthdayDate = sdf.parse(birthday);	 * String currTimeStr = sdf.format(new Date()); Date currDate =	 * sdf.parse(currTimeStr); if (birthdayDate.getTime() > currDate.getTime())	 * { return "0"; } long age = (currDate.getTime() - birthdayDate.getTime())	 * / (24 * 60 * 60 * 1000) + 1; String year = new	 * DecimalFormat("0.00").format(age / 365f); if (TextUtils.isEmpty(year))	 * return "0"; return String.valueOf(new Double(year).intValue()); } catch	 * (ParseException e) { e.printStackTrace(); } return "0"; }	 */	/**	 * 根据月日计算星座	 * 	 * @param month	 * @param day	 * @return	 */	/*	 * public String getAstro(int month, int day) { String[] astro = new	 * String[] { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座",	 * "天秤座", "天蝎座", "射手座", "摩羯座" }; int[] arr = new int[] { 20, 19, 21, 21, 21,	 * 22, 23, 23, 23, 23, 22, 22 };// 两个星座分割日 int index = month; //	 * 所查询日期在分割日之前，索引-1，否则不变 if (day < arr[month - 1]) { index = index - 1; } //	 * 返回索引指向的星座string return astro[index]; }	 */	public String getAstro(int month, int day) {		String star = "";		if (month == 1 && day >= 20 || month == 2 && day <= 18) {			star = "水瓶座";		}		if (month == 2 && day >= 19 || month == 3 && day <= 20) {			star = "双鱼座";		}		if (month == 3 && day >= 21 || month == 4 && day <= 19) {			star = "白羊座";		}		if (month == 4 && day >= 20 || month == 5 && day <= 20) {			star = "金牛座";		}		if (month == 5 && day >= 21 || month == 6 && day <= 21) {			star = "双子座";		}		if (month == 6 && day >= 22 || month == 7 && day <= 22) {			star = "巨蟹座";		}		if (month == 7 && day >= 23 || month == 8 && day <= 22) {			star = "狮子座";		}		if (month == 8 && day >= 23 || month == 9 && day <= 22) {			star = "处女座";		}		if (month == 9 && day >= 23 || month == 10 && day <= 22) {			star = "天秤座";		}		if (month == 10 && day >= 23 || month == 11 && day <= 21) {			star = "天蝎座";		}		if (month == 11 && day >= 22 || month == 12 && day <= 21) {			star = "射手座";		}		if (month == 12 && day >= 22 || month == 1 && day <= 19) {			star = "摩羯座";		}		return star;	}}