package com.proutils.library;

import android.app.Activity;
import android.view.Gravity;
import android.widget.Toast;



/**
 * Created by yangzhidan
 * description:
 */
public class ToastUtil {

    private static Toast toast = null;
    /**
     * 短时间显示Toast
     *
     * @param info 显示的内容
     */
    public static void showToast(Activity activity,String info) {
        //防止重复执行单一吐司操作
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
     * 短时间显示Toast显示在中间
     *
     * @param info 显示的内容
     */
    public static void showCenterToast(Activity activity,String info) {
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
     * 长时间显示Toast
     *
     * @param info 显示的内容
     */
    public static void showToastLong(Activity activity,String info) {
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
     * 短时间显示Toast
     */
    public static void showToast(Activity activity,int resId) {
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
     * 长时间显示Toast
     */
    public static void showToastLong(Activity activity,int resId) {
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
