package com.base.baselib;

import android.graphics.Bitmap;

public class ImgUtils {
    static {
        System.loadLibrary("native-lib");
    }


    public native void nativeCompress(Bitmap bitmap, int q, String path);



}
