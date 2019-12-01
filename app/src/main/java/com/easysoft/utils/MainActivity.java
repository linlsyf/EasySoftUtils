package com.easysoft.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.easysoft.utils.lib.http.CallBackResult;
import com.easysoft.utils.lib.http.EasyHttpCallback;
import com.easysoft.utils.lib.http.EasyHttpUtils;
import com.easysoft.utils.lib.http.IEasyResponse;
import com.easysoft.utils.lib.imge.ImageUtils;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mBtn=(Button)findViewById(R.id.btChange);

         mBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 String url="http://49.233.163.215:8080/api/v1/favour/search";
//                 String url="https://curly-cherry-1f65.jwdxhs.workers.dev/-----https://avmask.com/cn/released/page/31";
//                 String url="http://49.233.163.215:8080/easy/api/v1/favour/list";
//                 String url="https://jirenguapi.applinzi.com/fm/getSong.php?channel=public_yuzhong_yueyu";
                 EasyHttpUtils.getInStance(MainActivity.this).post(url,new IEasyResponse() {
                     @Override
                     public void onFailure(CallBackResult serviceCallBack) {
                         int  count=0;
                     }

                     @Override
                     public void onResponse(CallBackResult serviceCallBack) {

                         int  count=0;

                     }
                 });
//
//                 Intent  intent=new Intent(MainActivity.this,FragmentDyActivity.class);
//                 MainActivity.this.startActivity(intent);


//                 FragmentHelper.showFrag(MainActivity.this,R.id.contain_layout,new FragmentOne(),null);
             }
         });
//        ImageView myImageView=(ImageView)findViewById(R.id.contain_layout);





//        ImageView myImageView=(ImageView)findViewById(R.id.imgHead);
//
//
//                String url="http://49.233.163.215:8080/easy/api/v1/favour/list";
////                String url="http://qukufile2.qianqian.com/data2/pic/6ed6d59d11fb742adc3bee224f0583ad/590359391/590359391.jpg@s_2,w_300,h_300";
//
//                ImageUtils.getInStance(MainActivity.this).load(url,myImageView);




//        String url="http://p1.qzone.la/upload/20150102/a3zs6l69.jpg";
//        ImageUtils.getInStance(this).load(url,   myImageView);
////        String urlApk="http://10.0.0.96:8090/easy/api/v1/file/downApk";
//        String urlApk="http://18.222.51.213:8080/easy/api/v1/file/downApk";
//        EasyHttpUtils.getInStance().download(urlApk,"downapk.apk", Environment.getExternalStorageDirectory().getAbsolutePath(), new EasyHttpUtils.OnDownloadListener() {
//            @Override
//            public void onDownloadSuccess() {
//
//            }
//
//            @Override
//            public void onDownloading(int progress) {
//
//            }
//
//            @Override
//            public void onDownloadFailed() {
//
//            }
//        });
    }
}
