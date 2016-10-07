package com.hsd.fsxasm.mvp.model;


import com.hsd.fsxasm.mvp.bean.UserInformationBean;

import java.util.List;

/**
 * Created by apple on 16/9/29.
 */

public interface IRequestHeartBeatBiz {
    interface OnRequestListener{
        void success(List<UserInformationBean> userInformation);
        void failed();
    }
    void requestData(String uuid, OnRequestListener requestListener);
}
