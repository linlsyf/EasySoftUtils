package com.easysoft.utils.lib.video;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.easysoft.utils.lib.system.ToastUtils;

import java.io.File;

/**
 * Created by lindanghong on 2018/6/4.
 */

public class OpenFileUtils {
    public  static void openVideo(Activity activity, String path){
        try{
            Intent intent = new Intent(Intent.ACTION_VIEW);
//        String path = Environment.getExternalStorageDirectory().getPath()+ "/1.mp4";//该路径可以自定义
//            URLEncoder.encode(path,"utf-8");
            File file = new File(path);
            Uri uri = Uri.fromFile(file);
            intent.setDataAndType(uri, "video/*");
            activity.startActivity(intent);
        }catch (Exception e){
            ToastUtils.show(activity,"打开文件失败"+e.getMessage());
        }

    }


}
