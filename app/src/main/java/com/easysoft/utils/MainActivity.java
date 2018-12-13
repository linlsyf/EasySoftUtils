package com.easysoft.utils;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.easysoft.utils.lib.http.OkHttpUtils;
import com.easysoft.utils.lib.imge.ImageUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView myImageView=(ImageView)findViewById(R.id.imgHead);
        String url="http://p1.qzone.la/upload/20150102/a3zs6l69.jpg";
        ImageUtils.getInStance(this).load(url,   myImageView);
//        String url="http://p1.qzone.la/upload/20150102/a3zs6l69.jpg";
//        ImageUtils.getInStance(this).load(url,   myImageView);
//        Imag
//        String urlApk="http://10.0.0.96:8090/easy/api/v1/file/downApk";
////        String urlApk="http://18.222.51.213:8080/easy/api/v1/file/downApk";
//        OkHttpUtils.getInStance().download(urlApk, "/", new OkHttpUtils.OnDownloadListener() {
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
