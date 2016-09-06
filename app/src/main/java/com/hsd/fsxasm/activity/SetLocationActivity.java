package com.hsd.fsxasm.activity;import android.content.Context;import android.content.Intent;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.view.View.OnClickListener;import android.widget.RelativeLayout;import android.widget.TextView;import com.hsd.fsxasm.R;import com.hsd.fsxasm.base.BaseActivity;import com.hsd.fsxasm.widget.cityanddatewheel.wheelcity.AddressData;import com.hsd.fsxasm.widget.cityanddatewheel.wheelcity.OnWheelChangedListener;import com.hsd.fsxasm.widget.cityanddatewheel.wheelcity.WheelView;import com.hsd.fsxasm.widget.cityanddatewheel.wheelcity.adapters.AbstractWheelTextAdapter;import com.hsd.fsxasm.widget.cityanddatewheel.wheelcity.adapters.ArrayWheelAdapter;public class SetLocationActivity extends BaseActivity {	private View view = null;	private TextView homeText;	private String home;	private RelativeLayout homeChooseView;		private String cityTxt;			@Override	protected View initView() {		View parent = View.inflate(this, R.layout.il_setotherpersoninfo_setlocation, null);				Intent intent = getIntent();		homeText = (TextView) parent.findViewById(R.id.id_setotherpersoninfo_sethome_home);		homeText.setText(intent.getStringExtra("home"));		homeChooseView = (RelativeLayout) parent.findViewById(R.id.il_setotherpersoninfo_sethome_choose);		homeChooseView.addView(dialogm());		homeText.setText(intent.getStringExtra("home"));		return parent;	}	@Override	protected void updataUI(Object obj) {		// TODO Auto-generated method stub	}	@Override	protected void initData() {		mBack.setVisibility(view.VISIBLE);		mTitle.setText("设置家乡");		mHelp.setVisibility(View.VISIBLE);		mHelp.setText("完成");	}	@Override	protected void setListener() {		mBack.setOnClickListener(new OnClickListener() {			@Override			public void onClick(View v) {				home = homeText.getText().toString();				Intent intent = getIntent();				intent.putExtra("hom234e", home);				setResult(123132, intent);				finish();			}		});		mHelp.setOnClickListener(new OnClickListener() {			@Override			public void onClick(View v) {				finish1();			}		});	}		@Override	public void onBackPressed() {		home = homeText.getText().toString();		Intent intent = getIntent();		intent.putExtra("hom234e", home);		setResult(123132, intent);		finish();//		super.onBackPressed();	}		/**	 * 关闭Activity并返回值	 */	private void finish1(){		home = homeText.getText().toString();		Intent intent = getIntent();		intent.putExtra("home", home);		this.setResult(12, intent);		finish();	}		private View dialogm() {		View contentView = LayoutInflater.from(this).inflate(				R.layout.wheelcity_cities_layout, null);		final WheelView country = (WheelView) contentView				.findViewById(R.id.wheelcity_country);		country.setVisibleItems(3);		country.setViewAdapter(new CountryAdapter(this));		final String cities[][] = AddressData.CITIES;		final String ccities[][][] = AddressData.COUNTIES;		final WheelView city = (WheelView) contentView				.findViewById(R.id.wheelcity_city);		city.setVisibleItems(0);		// 地区选择		final WheelView ccity = (WheelView) contentView				.findViewById(R.id.wheelcity_ccity);		ccity.setVisibleItems(0);// 不限城市		country.addChangingListener(new OnWheelChangedListener() {			public void onChanged(WheelView wheel, int oldValue, int newValue) {				updateCities(city, cities, newValue);				cityTxt = AddressData.PROVINCES[country.getCurrentItem()]						+ " | "						+ AddressData.CITIES[country.getCurrentItem()][city								.getCurrentItem()]						+ " | "						+ AddressData.COUNTIES[country.getCurrentItem()][city								.getCurrentItem()][ccity.getCurrentItem()];				homeText.setText(cityTxt);			}		});		city.addChangingListener(new OnWheelChangedListener() {			public void onChanged(WheelView wheel, int oldValue, int newValue) {				updatecCities(ccity, ccities, country.getCurrentItem(),						newValue);				cityTxt = AddressData.PROVINCES[country.getCurrentItem()]						+ " | "						+ AddressData.CITIES[country.getCurrentItem()][city								.getCurrentItem()]						+ " | "						+ AddressData.COUNTIES[country.getCurrentItem()][city								.getCurrentItem()][ccity.getCurrentItem()];				homeText.setText(cityTxt);			}		});		ccity.addChangingListener(new OnWheelChangedListener() {			public void onChanged(WheelView wheel, int oldValue, int newValue) {				cityTxt = AddressData.PROVINCES[country.getCurrentItem()]						+ " | "						+ AddressData.CITIES[country.getCurrentItem()][city								.getCurrentItem()]						+ " | "						+ AddressData.COUNTIES[country.getCurrentItem()][city								.getCurrentItem()][ccity.getCurrentItem()];				homeText.setText(cityTxt);			}		});		country.setCurrentItem(1);// 设置北京		city.setCurrentItem(1);		ccity.setCurrentItem(1);		return contentView;	}	/**	 * Updates the city wheel	 */	private void updateCities(WheelView city, String cities[][], int index) {		ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(this,				cities[index]);		adapter.setTextSize(18);		city.setViewAdapter(adapter);		city.setCurrentItem(0);	}	/**	 * Updates the ccity wheel	 */	private void updatecCities(WheelView city, String ccities[][][], int index,			int index2) {		ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(this,				ccities[index][index2]);		adapter.setTextSize(18);		city.setViewAdapter(adapter);		city.setCurrentItem(0);	}	/**	 * Adapter for countries	 */	private class CountryAdapter extends AbstractWheelTextAdapter {		// Countries names		private String countries[] = AddressData.PROVINCES;		/**		 * Constructor		 */		protected CountryAdapter(Context context) {			super(context, R.layout.wheelcity_country_layout, NO_RESOURCE);			setItemTextResource(R.id.wheelcity_country_name);		}		@Override		public View getItem(int index, View cachedView, ViewGroup parent) {			View view = super.getItem(index, cachedView, parent);			return view;		}		@Override		public int getItemsCount() {			return countries.length;		}		@Override		protected CharSequence getItemText(int index) {			return countries[index];		}	}}