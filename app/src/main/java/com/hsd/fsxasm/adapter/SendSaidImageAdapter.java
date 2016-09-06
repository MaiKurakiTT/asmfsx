package com.hsd.fsxasm.adapter;import java.util.ArrayList;import com.hsd.fsxasm.R;import com.hsd.fsxasm.utils.NativeImageLoader;import com.hsd.fsxasm.utils.NativeImageLoader.NativeImageCallBack;import android.app.Activity;import android.content.Intent;import android.graphics.Bitmap;import android.graphics.Point;import android.view.View;import android.view.ViewGroup;import android.view.View.OnClickListener;import android.widget.BaseAdapter;import android.widget.Button;import android.widget.GridView;import android.widget.ImageButton;import android.widget.ImageView;public class SendSaidImageAdapter extends BaseAdapter {	private ArrayList<String> images;	private Activity mActivity;	private Point mPoint = new Point(100, 100);// 用来封装ImageView的宽和高的对象	private GridView gridView;	private MyOnClickAddImageListener listener;	public SendSaidImageAdapter(ArrayList<String> lists, Activity mActivity,			GridView gridView, MyOnClickAddImageListener listener) {		super();		images = lists;		this.mActivity = mActivity;		this.gridView = gridView;		this.listener = listener;	}	public void setData(ArrayList<String> images) {		this.images = images;	}	@Override	public int getCount() {		if (images == null || images.size() == 0) {			return 1;		}		return images.size() + 1;	}	@Override	public Object getItem(int position) {		// TODO Auto-generated method stub		return position;	}	@Override	public long getItemId(int position) {		// TODO Auto-generated method stub		return position;	}	@Override	public View getView(int position, View convertView, ViewGroup parent) {		// TODO Auto-generated method stub		System.out.println("测试一下有多少个item" + position);		Holder holder = null;		if (images == null || position == images.size() || images.size() == 0) {			System.out.println("添加图片的position" + position);			ImageButton button = new ImageButton(mActivity);			button.setImageResource(R.drawable.ic_addphotoclick);			button.setOnClickListener(new OnClickListener() {				@Override				public void onClick(View v) {					// TODO Auto-generated method stub					System.out.println("单机了按钮");					listener.onClick();				}			});			return button;		}		if (convertView == null) {			System.out.println(mActivity);			holder = new Holder();			convertView = View.inflate(mActivity, R.layout.images_item, null);			ImageView imageView = (ImageView) convertView					.findViewById(R.id.fabu_image);			holder.imageView = imageView;			convertView.setTag(holder);		} else {			holder = (Holder) convertView.getTag();		}		Bitmap bitmap = NativeImageLoader.getInstance().loadNativeImage(				images.get(position), mPoint, new NativeImageCallBack() {					@Override					public void onImageLoader(Bitmap bitmap, String path) {						ImageView mImageView = (ImageView) gridView								.findViewWithTag(path);						if (bitmap != null && mImageView != null) {							mImageView.setImageBitmap(bitmap);						}					}				});		if (bitmap != null) {			holder.imageView.setImageBitmap(bitmap);		}		return convertView;	}	public class Holder {		ImageView imageView;	}	public interface MyOnClickAddImageListener {		void onClick();	}}