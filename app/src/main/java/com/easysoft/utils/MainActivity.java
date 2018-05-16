package com.easysoft.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.easysoft.utils.lib.imge.ImageUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView myImageView=(ImageView)findViewById(R.id.imgHead);
        String url="http://p1.qzone.la/upload/20150102/a3zs6l69.jpg";
        ImageUtils.getInStance(this).load(url,   myImageView);
//        Imag
    }
}
