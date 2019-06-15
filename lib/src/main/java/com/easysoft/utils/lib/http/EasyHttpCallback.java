package com.easysoft.utils.lib.http;


import com.alibaba.fastjson.JSON;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

public   class EasyHttpCallback implements Callback {
	CallBackResult serviceCallBack=new CallBackResult();

	IEasyResponse  iResponse;
	boolean outside=false;


	public EasyHttpCallback setOutside(boolean outside) {
		this.outside = outside;
		return this;
	}

	public EasyHttpCallback(IEasyResponse iResponse) {
		super();
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
			String msg = body.string();

			  if (!outside){

				  ResponseMsg responseMsg = JSON.parseObject(msg, ResponseMsg.class);

				  serviceCallBack.setResponseMsg(responseMsg);
			  }else{
				  ResponseMsg responseMsg=new ResponseMsg();
				  responseMsg.setData(msg);
				  serviceCallBack.setResponseMsg(responseMsg);

			  }
			

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
	 
//	  public  interface IResponse{
//		  void onFailure(CallBackResult serviceCallBack);
//		  void onResponse(CallBackResult serviceCallBack);
//	  }
}
