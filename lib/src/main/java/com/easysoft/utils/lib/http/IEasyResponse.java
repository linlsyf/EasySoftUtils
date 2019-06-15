package com.easysoft.utils.lib.http;

/**
 * Created by Administrator on 2019/5/19 0019.
 */

public interface IEasyResponse {
    void onFailure(CallBackResult serviceCallBack);
    void onResponse(CallBackResult serviceCallBack);
}
