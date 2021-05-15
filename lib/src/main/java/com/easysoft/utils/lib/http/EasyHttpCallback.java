package com.easysoft.utils.lib.http;
import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.easysoft.utils.lib.system.ToastUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
public   class EasyHttpCallback implements Callback {
	private final Context mContext;
	CallBackResult serviceCallBack=new CallBackResult();
    public   String mResponseCharset="utf-8";

	IEasyResponse  iResponse;
	boolean outside=true;

	public EasyHttpCallback setOutside(boolean outside) {
		this.outside = outside;
		return this;
	}

	public EasyHttpCallback(Context context,IEasyResponse iResponse) {
		super();
		this.mContext=context;
		this.iResponse = iResponse;
	}

	@Override
	public void onFailure(final Call call, IOException e) {
		serviceCallBack.setCall(call);
		serviceCallBack.setExcept(e);
		iResponse.onResponse(serviceCallBack);
	}
	@Override
	public void onResponse(Call call, Response response) throws IOException{
		if (response.isSuccessful()) {
			serviceCallBack.setSucess(true);
			ResponseBody body = response.body();
            String msg;
            if (!mResponseCharset.equals("utf-8")){
               msg = new String(body.bytes(), mResponseCharset); //然后将其转为gb2312
             }else{
                msg = body.string();

            }
			  try {
				  if (!outside){
					  ResponseMsg responseMsg = JSON.parseObject(msg, ResponseMsg.class);
					  serviceCallBack.setResponseMsg(responseMsg);
				  }else{
					  ResponseMsg responseMsg=new ResponseMsg();
					  responseMsg.setData(msg);
					  serviceCallBack.setResponseMsg(responseMsg);
				  }
			  }catch (Exception e){
				  ToastUtils.show(mContext, e.getMessage()+"");
			  }

	    }else{
			serviceCallBack.setSucess(false);
		}
		serviceCallBack.setCall(call);
		serviceCallBack.setResponse(response);
		iResponse.onResponse(serviceCallBack);

	}
	public CallBackResult getServiceCallBack() {
		return serviceCallBack;
	}

	public void setServiceCallBack(CallBackResult serviceCallBack) {
		this.serviceCallBack = serviceCallBack;
	}

    public String getResponseCharset() {
        return mResponseCharset;
    }

    public void setResponseCharset(String mResponseCharset) {
        this.mResponseCharset = mResponseCharset;
    }
}
