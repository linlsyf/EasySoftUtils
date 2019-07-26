package com.easysoft.utils.lib.imge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.easysoft.utils.lib.R;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class ImageUtils {
	
	static ImageUtils  utils;
	static Context mContext;
	 public static ImageUtils getInStance(Context context){
		 if(utils==null){
			 utils=new    ImageUtils();
		 }
		 mContext=context;
		 return  utils;
	 }
	
	public void load(final String url, final ImageView myImageView){

				Glide.with(mContext)
						.load(url)
						.apply(ImageRequestOptions.getInstance())
						.into(myImageView);

	}
	public void loadPath(final String path, final ImageView myImageView){
				Glide.with(mContext)


						.load(new File(path))
						.apply(ImageRequestOptions.getInstance())
						.into(myImageView);
	}
	public void loadResourceId(int id,ImageView myImageView){
		Glide.with(mContext)
		.load(id)
				.apply(ImageRequestOptions.getInstance())
		.into(myImageView);
		
	}

	public void  load(Bitmap bitmap, ImageView imageView){
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
		byte[] bytes=baos.toByteArray();

		Glide.with(mContext)
				.load(bytes)
				.apply(ImageRequestOptions.getInstance())
				.into(imageView);
	}


	

}
