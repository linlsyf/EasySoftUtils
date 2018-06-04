package com.easysoft.utils.lib.video;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;


public class VideoUtils {
	private static StringBuilder mFormatBuilder = new StringBuilder();
	private static Formatter mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());

	static ArrayList listItems ;



	private static final String[] VIDEOTHUMBNAIL_TABLE = new String[] {
			MediaStore.Video.Media._ID, // 0
			MediaStore.Video.Media.DATA, // 1 from android.provider.MediaStore.Video
	};
	 public  static ArrayList<VideoItem> getVideodData(final Context context) {
//	        new Thread(new Runnable() {
//	            @Override
//	            public void run() {
	            	       listItems = new ArrayList<VideoItem>();




		 Uri videoUri = MediaStore.Video.Thumbnails.getContentUri("external");




	                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
	                String[] projection = { MediaStore.Video.Media.DISPLAY_NAME,
	                        MediaStore.Video.Media.DURATION, MediaStore.Video.Media.SIZE,
	                        MediaStore.Video.Media.DATA };
	                Cursor cursor = getContentResolver(context).query(uri, projection, null, null, null);
	                while (cursor.moveToNext()) {
	                    String name = cursor.getString(0);//文件名
	                    long duration = cursor.getLong(1);//文件时长
	                    long size = cursor.getLong(2);//文件大小
	                    String data = cursor.getString(3);//文件路径

	                    VideoItem item = new VideoItem();
	                    item.setName(name);
                       item.setDuration(duration);
	                    item.setDurationString(stringForTime((int)duration));
	                    item.setSize(size);
	                    item.setData(data);

//						String thumbPath=ThumbnailQuery.queryImageThumbnailByPath(context,data);

						String thumbPath="";
						item.setThumbPath(thumbPath);

						 item.setBitmap(geThumbnailByMediaMetadata(data,200,100));

	                    listItems.add(item);
	                }


	                cursor.close();
//	                Message message = handler.obtainMessage();
//	                int what = 1;
//	                handler.sendEmptyMessage(what);

	                 return listItems;
//	            }
//	        }).start();


	    }
	/**
	 * 把毫秒转换成：1:20:30这里形式
	 * @param timeMs
	 * @return
	 */
	public static String stringForTime(int timeMs) {
		int totalSeconds = timeMs / 1000;
		int seconds = totalSeconds % 60;


		int minutes = (totalSeconds / 60) % 60;


		int hours = totalSeconds / 3600;


		mFormatBuilder.setLength(0);
		if (hours > 0) {
			return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
		} else {
			return mFormatter.format("%02d:%02d", minutes, seconds).toString();
		}
	}

	protected static ContentResolver getContentResolver(Context context) {
		ContentResolver contentResolver = context.getContentResolver();
		
	
		return contentResolver;
	}
	private Bitmap getVideoThumbnail(String videoPath, int width, int height,
                                     int kind) {
		Bitmap bitmap = null;
		// 获取视频的缩略图
		// kind could be MINI_KIND or MICRO_KIND
		bitmap = ThumbnailUtils.createVideoThumbnail(videoPath, kind);
		bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
				ThumbnailUtils.OPTIONS_RECYCLE_INPUT);

		return bitmap;
	}
	public static Bitmap geThumbnailByMediaMetadata(String videoPath, int width, int height) {
		String path  = Environment.getExternalStorageDirectory().getPath();
		MediaMetadataRetriever media = new MediaMetadataRetriever();
		media.setDataSource(videoPath);
		Bitmap bitmap = media.getFrameAtTime();


		return bitmap;
	}
}

