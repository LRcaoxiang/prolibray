package com.proutils.library;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;



/**
 * Created by yangzhidan
 * description:
 */
public class ToastUtil {

    private static Toast toast = null;
    /**
     * duan  Toast
     *
     * @param info
     */
    public static void showToast(Context activity, String info) {
        if (StringUtils.isEmpty(info))
            return;
        if (toast == null) {
            toast = Toast.makeText(activity, info, Toast.LENGTH_SHORT);
        } else {
            toast.setText(info);
        }
        toast.show();
    }
    /**
     * Long Toast
     *
     * @param info
     */
    public static void showCenterToast(Context activity,String info) {
        if (StringUtils.isEmpty(info))
            return;
        if (toast == null) {
            toast = Toast.makeText(activity, info, Toast.LENGTH_SHORT);
        } else {
            toast.setGravity(Gravity.CENTER,0,0);
            toast.setText(info);
        }
        toast.show();
    }


    /**
     *
     *
     * @param info
     */
    public static void showToastLong(Context activity,String info) {
        if (StringUtils.isEmpty(info))
            return;
        if (toast == null) {
            toast = Toast.makeText(activity, info, Toast.LENGTH_LONG);
        } else {
            toast.setText(info);
        }
        toast.show();
    }

    /**
     *
     */
    public static void showToast(Context activity,int resId) {
        if (StringUtils.isEmpty(activity.getString(resId)))
            return;
        if (toast == null) {
            toast = Toast.makeText(activity, activity.getString(resId), Toast.LENGTH_SHORT);
        } else {
            toast.setText(activity.getString(resId));
        }
        toast.show();
    }

    /**
     *
     */
    public static void showToastLong(Context activity,int resId) {
        if (StringUtils.isEmpty(activity.getString(resId)))
            return;
        if (toast == null) {
            toast = Toast.makeText(activity, activity.getString(resId), Toast.LENGTH_LONG);
        } else {
            toast.setText(activity.getString(resId));
        }
        toast.show();
    }

}
