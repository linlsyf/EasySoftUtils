package com.easysoft.utils.lib.imge;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.easysoft.utils.lib.R;



public class ImageRequestOptions extends RequestOptions {

    static ImageRequestOptions  imageRequestOptions;

    public static  ImageRequestOptions getInstance() {
        if (null == imageRequestOptions) {
           imageRequestOptions=new ImageRequestOptions();
            imageRequestOptions.placeholder(R.drawable.empty_photo)//图片加载出来前，显示的图片
                    .fallback( R.drawable.empty_photo) //url为空的时候,显示的图片
                    .error( R.drawable.empty_photo).
                    bitmapTransform(new RoundedCorners(30));//图片圆角为30
                         ;//图片加载失败后，显示的图片
        }
        return imageRequestOptions;
    }

}
