package com.easysoft.utils.lib.system;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;

import java.io.File;

@TargetApi(Build.VERSION_CODES.GINGERBREAD) public class SdCardUtils {



	public static File getSDcardFile() {
		return Environment.getExternalStorageDirectory();
	}
}
