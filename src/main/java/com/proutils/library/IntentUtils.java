package com.proutils.library;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.FileProvider;


import java.io.File;

/**
 * Created by lizhangfeng on 16/6/4.
 * description: go Class
 */
public class IntentUtils {

    /**
     *
     * @param context
     * @param pClass
     */
    public static void openActivity(Context context, Class<?> pClass) {
        openActivity(context, pClass, null);
    }

    /**
     *
     * @param context
     * @param pClass
     * @param pBundle
     */
    public static void openActivity(Context context, Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(context, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        context.startActivity(intent);
    }

    /**
     *
     * @param context
     * @param pAction
     */
    public void openActivity(Context context, String pAction) {
        openActivity(context, pAction, null);
    }

    /**
     *
     * @param context thisushdihifhs
     * @param pAction
     * @param pBundle
     */
    public static void openActivity(Context context, String pAction, Bundle pBundle) {
        Intent intent = new Intent(pAction);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        context.startActivity(intent);
    }

    /**
     *
     * @param activity
     * @param appFile
     */
    public static void goDownlInstall(Activity activity,File appFile){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(activity, "com.dinpay.trip.fileprovider", appFile);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(appFile), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
    }

    /**
     *
     * @param context
     * @param phone  这里有中文
     */
    public static void call(Context context, String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
