package com.hsd.fsxasm.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hsd.fsxasm.R;
import com.hsd.fsxasm.mvp.bean.UserInformationBean;
import com.hsd.fsxasm.widget.CircleImageView;

import java.util.Date;
import java.util.List;


/**
 * Created by apple on 16/10/5.
 */

public class HeartBeatListAdapter extends BaseAdapter {



    private Context context;
    private List<UserInformationBean> userInformationList;
    public String TAG = "HeartBeatListAdapter";
    private final LayoutInflater layoutInflater;

    public HeartBeatListAdapter(Context context, List<UserInformationBean> userInformationList) {
        this.context = context;
        this.userInformationList = userInformationList;
        layoutInflater = LayoutInflater.from(context);
    }

    /*@Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.heartbeat_cardview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Log.d(TAG, "当前显示的是 == " + userInformationList.get(position).getUser_nickname());
        holder.likelistName.setText(userInformationList.get(position).getUser_nickname());
        Glide.with(context).load(userInformationList.get(position).getUser_icon()).into(holder.likelistHead);
        holder.likelistSex.setText(userInformationList.get(position).getUser_sex());
        Date birthday = userInformationList.get(position).getUser_birthday();
        holder.likelistAge.setText(GetAgeFromDate.getAge(birthday) + "");
        holder.likelistNolikeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowToast.show(context, "点击了不喜欢" + position);
            }
        });
        holder.likelistChatBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowToast.show(context, "点击了聊天" + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userInformationList.size();
    }
*/
    @Override
    public int getCount() {
        return userInformationList.size();
    }

    @Override
    public Object getItem(int position) {
        return userInformationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if (convertView == null){
            myViewHolder = new MyViewHolder();
            convertView = layoutInflater.inflate(R.layout.like_list_item, parent, false);
            myViewHolder.likelistHead = (CircleImageView) convertView
                    .findViewById(R.id.likelist_head);
            myViewHolder.likelistName = (TextView) convertView
                    .findViewById(R.id.likelist_name);
            myViewHolder.likelistAge = (TextView) convertView
                    .findViewById(R.id.likelist_age);
            myViewHolder.likelistSex = (TextView) convertView
                    .findViewById(R.id.likelist_sex);
            myViewHolder.likelistNolikeBt = (ImageView) convertView
                    .findViewById(R.id.likelist_nolike_bt);
            myViewHolder.likelistChatBt = (ImageView) convertView
                    .findViewById(R.id.likelist_chat_bt);
            convertView.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        UserInformationBean informationBean = userInformationList.get(position);
        myViewHolder.likelistName.setText(informationBean.getUser_nickname());
        return convertView;
    }


    private class MyViewHolder{

        CircleImageView likelistHead;
        TextView likelistName;
        TextView likelistSex;
        TextView likelistAge;
        ImageView likelistNolikeBt;
        ImageView likelistChatBt;
        /*public MyViewHolder(View itemView) {
            likelistHead = (CircleImageView) itemView.findViewById(R.id.likelist_head);
            likelistName = (TextView) itemView.findViewById(R.id.likelist_name);
            likelistSex = (TextView) itemView.findViewById(R.id.likelist_sex);
            likelistAge = (TextView) itemView.findViewById(R.id.likelist_age);
            likelistNolikeBt = (ImageView) itemView.findViewById(R.id.likelist_nolike_bt);
            likelistChatBt = (ImageView) itemView.findViewById(R.id.likelist_chat_bt);
        }*/
    }
}
