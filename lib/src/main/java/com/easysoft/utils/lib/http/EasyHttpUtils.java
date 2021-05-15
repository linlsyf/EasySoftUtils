package com.easysoft.utils.lib.http;

import android.content.Context;

import com.easysoft.utils.lib.system.ToastUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EasyHttpUtils {
	
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	public static  OkHttpClient client ;
	public static   Context mContext;
    public static  String mResponseCharset="utf-8";
	static EasyHttpUtils utils;
	 public static EasyHttpUtils getInStance(Context context){
		 mContext=context;

		 if(utils==null){
			 utils=new EasyHttpUtils();
			 client = new OkHttpClient();
		 }
		 return  utils;
	 }
	 public static EasyHttpUtils setCharset(String charset){
         mResponseCharset=charset;
        return utils;
	 }
	 public static EasyHttpUtils init(Map initMap){
	 	  if (initMap.containsKey("responseCharset")){
			  mResponseCharset=(String) initMap.get("responseCharset");
		  }

		 return utils;
	 }

	public void post(String url ,boolean outParser,IEasyResponse iEasyResponse ) {
		EasyHttpCallback callBack=new EasyHttpCallback(mContext, iEasyResponse);
		callBack.setResponseCharset(mResponseCharset);
		  callBack.setOutside(outParser);
		post(url,callBack );


	}
	public void post(String url ,IEasyResponse iEasyResponse )  {
		EasyHttpCallback callBack=new EasyHttpCallback(mContext, iEasyResponse);
        callBack.setResponseCharset(mResponseCharset);

        post(url,callBack );

	}
	
	public void post(String url,   EasyHttpCallback callBack)  {
		String json="";
//		MediaType JSONNew = MediaType.parse("application/json; charset=gbk");
        //		RequestBody body = RequestBody.create(JSONNew, json);

        RequestBody body = RequestBody.create(JSON, json);
		try {
	    Request request = new Request.Builder()
	      .url(url)
	      .post(body)
	      .build();

			 Call call = client.newCall(request);
			 call.enqueue(callBack);


		} catch (Exception e) {

			ToastUtils.show(mContext,e.getMessage());
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	public void uploadFile(String url, String filepath, String fileName,  EasyHttpCallback callBack)  {
		 File file = new File(filepath);
	        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
	        RequestBody requestBody = new MultipartBody.Builder()
	                .setType(MultipartBody.FORM) 
	                .addFormDataPart("file", file.getName(), fileBody)
	                .build();
		try {
			  Request request = new Request.Builder()
              .url(url)
              .post(requestBody)
              .build();
			  
			Call call = client.newCall(request);
			call.enqueue(callBack);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param url 下载连接
	 * @param saveDir 储存下载文件的SDCard目录
	 * @param listener 下载监听
	 */
	public void download(final String url,String fileName, final String saveDir, final OnDownloadListener listener) {
		Request request = new Request.Builder().addHeader("Accept-Encoding", "identity")
				.url(url).build();

		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				listener.onDownloadFailed();	// 下载失败
			}
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				InputStream is = null;
				byte[] buf = new byte[2048];
				int len ;
				FileOutputStream fos = null;// 储存下载文件的目录
				String savePath = isExistDir(saveDir);
				try {
					is = response.body().byteStream();
					long total = response.body().contentLength();
					File file = new File(savePath,fileName);
					fos = new FileOutputStream(file);
					long sum = 0;
					while ((len = is.read(buf)) != -1) {
						fos.write(buf, 0, len);
						sum += len;
						int progress = (int) (sum * 1.0f / total) * 100;
//						int progress = (int) (sum * 1.0f / total * 100);
						listener.onDownloading(progress);// 下载中
					}
					fos.flush();
					listener.onDownloadSuccess();// 下载完成
				} catch (Exception e) {
					listener.onDownloadFailed();
				} finally {
					try {
						if (is != null)
							is.close();
					} catch (IOException e) {
					}
					try {
						if (fos != null)
							fos.close();
					} catch (IOException e) {
						System.out.print("下载文件错误"+e.getMessage());
						//ToastUtils.show(getInStance().get);
					}
				}
			}
		});
	}

	/**
	 * @param saveDir
	 * @return
	 * @throws IOException
	 * 判断下载目录是否存在
	 */
	private String isExistDir(String saveDir) throws IOException {
		File downloadFile = new File(saveDir);	// 下载位置
		if (!downloadFile.mkdirs()) {
			downloadFile.createNewFile();
		}
		String savePath = downloadFile.getAbsolutePath();
		return savePath;
	}

	/**
	 * @param url
	 * @return
	 * 从下载连接中解析出文件名
	 */
	private String getNameFromUrl(String url) {
		return url.substring(url.lastIndexOf("/") + 1);
	}

	public interface OnDownloadListener {
		/**
		 * 下载成功
		 */
		void onDownloadSuccess();

		/**
		 * @param progress
		 * 下载进度
		 */
		void onDownloading(int progress);

		/**
		 * 下载失败
		 */
		void onDownloadFailed();
	}


}
