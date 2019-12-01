package com.easysoft.utils.lib.http;
import okhttp3.Call;
import okhttp3.Response;
public class CallBackResult {
	boolean isSucess=false;
	Call call;
	Response response;
	Exception except;
	ResponseMsg responseMsg ;
	String    msg;
	public boolean isSucess() {
		return isSucess;
	}
	public void setSucess(boolean isSucess) {
		this.isSucess = isSucess;
	}
	public Call getCall() {
		return call;
	}
	public void setCall(Call call) {
		this.call = call;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public ResponseMsg getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(ResponseMsg responseMsg) {
		this.responseMsg = responseMsg;
	}
	public Exception getExcept() {
		return except;
	}
	public void setExcept(Exception except) {
		this.except = except;
	}

	
}
