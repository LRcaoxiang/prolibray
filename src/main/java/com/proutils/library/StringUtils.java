package com.proutils.library;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类名称 ：StringUtils 类描述 ：String判断处理工具类
 */
public class StringUtils {

    //本地显示图片路径
    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    public static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }

    //字符串改变颜色
    public static SpannableString changTextSpann(int textLen, String count, String addStr) {
        SpannableString string = null;
        if (isEmpty(count)) {
            return string;
        }
        string = new SpannableString(count + addStr);
        //设置前景色
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#FF8338"));
        string.setSpan(colorSpan1, 0, textLen, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return string;
    }


    //字符串改变颜色
    public static SpannableString changTextSpannBlue(int textLen, String count, String addStr) {
        SpannableString string = null;
        if (isEmpty(count)) {
            return string;
        }
        string = new SpannableString(count + addStr);
        //设置前景色
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#007fff"));
        string.setSpan(colorSpan1, 0, textLen, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return string;
    }


    //字符串改变颜色
    public static SpannableString changTextSpann(int textLen, String addStr01, String count, String addStr02) {
        SpannableString string = null;
        if (isEmpty(count)) {
            return string;
        }
        string = new SpannableString(addStr01 + count + addStr02);
        //设置前景色
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#FF4444"));
        string.setSpan(colorSpan1, addStr01.length(), textLen, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return string;
    }


    //字符串改变颜色
    public static SpannableString changTextSpann02(int textLen, String addStr01, String count, String addStr02) {
        SpannableString string = null;
        if (isEmpty(count)) {
            return string;
        }
        string = new SpannableString(addStr01 + count + addStr02);
        //设置前景色
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#FF4444"));
        string.setSpan(colorSpan1, addStr01.length(), textLen - 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return string;
    }


    //使用String的split 方法
    public static String[] convertStrToArray(String str) {
        String[] strArray = null;
        if (isEmpty(str)) {
            return strArray;
        }
        strArray = str.split("-"); //拆分字符为"-" ,然后把结果交给数组strArray
        return strArray;
    }


    /**
     * 判断字符串是否为null或者空字符串
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        boolean result = false;
        if (null == str || "".equals(str.trim())) {
            result = true;
        }
        return result;
    }


    /**
     * 解析url编码的字符串
     *
     * @param text
     * @return
     */
    public static String EndcodeUrlText(String text) {
        String codeText = null;
        if (text != null) {
            try {
                codeText = URLDecoder.decode(text, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return codeText;
    }


    /**
     * 获取输入的字符串
     *
     * @param editText
     * @return
     */
    public static String getEditString(EditText editText) {
        String str = "";
        if (editText != null) {
            str = editText.getText().toString().trim();
            return str;
        }
        return str.replaceAll(" +", "");
    }

    /**
     * 获取输入的字符串
     *
     * @param editText
     * @return
     */
    public static String getTextString(TextView editText) {
        String str = "";
        if (editText != null) {
            str = editText.getText().toString().trim();
            return str;
        }
        return str;
    }


    /**
     * 获取字符串的长度
     */
    public static int getStringLenth(String s) {
        return isEmpty(s) || "null".equals(s) ? 0 : s.length();
    }

    /**
     * 判断字符串是否在范围内
     */
    public static boolean getIsStringOk(String s, int small, int big) {
        int stringLength = s.length();
        if (stringLength >= small && stringLength <= big) {
            return true;
        } else {
            ToastUtil.showToast("请输入" + small + "-" + big + "位的密码");
            return false;
        }
    }


    /**
     * @param string
     * @return
     */
    public static boolean isNotEmpty(String string) {
        if (null != string && !"".equals(string.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 去掉一个字符串中的所有的单个空格" "
     *
     * @param string
     */
    public static String replaceSpaceCharacter(String string) {
        if (null == string || "".equals(string)) {
            return "";
        }
        return string.replace(" ", "");
    }

    /**
     * 获取小数位为6位的经纬度
     *
     * @param string
     * @return
     */
    public static String getStringLongitudeOrLatitude(String string) {
        if (StringUtils.isEmpty(string)) {
            return "";
        }
        if (string.contains(".")) {
            String[] splitArray = string.split("\\.");
            if (splitArray[1].length() > 6) {
                String substring = splitArray[1].substring(0, 6);
                return splitArray[0] + "." + substring;
            } else {
                return string;
            }
        } else {
            return string;
        }
    }

    /**
     * 检查是否有中文
     *
     * @param str
     * @return
     */
    public static boolean checkString(String str) {
        boolean res = false;
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                // 只要字符串中有中文则为中文
                if (!checkChar(str.charAt(i))) {
                    res = true;
                    break;
                } else {
                    res = false;
                }
            }
        }
        return res;
    }

    // 英文占1byte，非英文（可认为是中文）占2byte，根据这个特性来判断字符
    public static boolean checkChar(char ch) {
        if ((ch + "").getBytes().length == 1) {
            return true;// 英文
        } else {
            return false;// 中文
        }
    }

    /**
     * 转化成int
     *
     * @param s
     * @return
     */
    public static int getInteger(String s) {
        return isEmpty(s) ? 0 : Integer.parseInt(s);
    }

    /**
     * 获取数量s
     *
     * @param s
     * @return
     */
    public static String getNumString(String s) {
        return isEmpty(s) || "null".equals(s) ? "0" : s;
    }


    /**
     * 距离处理
     *
     * @param distance
     */
    public static String getDistance(String distance) {
        if (StringUtils.isEmpty(distance) || "null".equals(distance))
            return "";
        try {
            float dis = Float.parseFloat(distance);
            if (dis > 1000) {

                String ds = "" + dis / 1000;

                int index = ds.indexOf(".");
                if (index != -1)
                    return ds.substring(0, index + 2) + "km";
                return ds + "km";

            } else {
                return "" + (int) dis + "m";
            }
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取简介
     *
     * @param desc
     * @return
     */
    public static String getDesc(String desc) {
        return isEmpty(desc) ? "无" : desc;
    }

    /**
     * 判断是不是一个url
     *
     * @param url
     * @return
     */
    public static boolean isCorrectUrl(String url) {
        if (isEmpty(url))
            return false;

        if (url.startsWith("http"))
            return true;
        if (url.startsWith("fttp"))
            return true;

        return false;
    }

    /**
     * 显示消息的数量
     *
     * @param count
     * @return
     */
    public static String getMsgCount(int count) {
        if (count > 99)
            return "99+";
        return "" + count;
    }

    /**
     * 通过string获取uri
     *
     * @param url
     * @return
     */
    public static Uri getUri(String url) {
        return Uri.parse(isEmpty(url) ? "" : url);
    }

    /**
     * 保留两位小数
     *
     * @return
     */
    public static String doubleFormat(String value) {
        try {
            DecimalFormat df = new DecimalFormat("######0.00");
            return df.format(Double.parseDouble(value));
        } catch (Exception e) {
            return "";
        }

    }

    /**
     * 保留yi位小数
     *
     * @return
     */
    public static String doubleFormatone(String value) {
        try {
            DecimalFormat df = new DecimalFormat("######.#");
            return df.format(Double.parseDouble(value));
        } catch (Exception e) {
            return "";
        }

    }


    public static String longToStrng(Long time, String format) {
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(date);
        return dateString;
    }


    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）/^0?1[3|4|5|7|8][0-9]\d{8}$/
    总结起来就是第一位必定为1，第二位必定为3或5或8或7（电信运营商），其他位置的可以为0-9
    */
        String telRegex = "[1][34578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (isEmpty(mobiles))
            return false;
        else
            return mobiles.matches(telRegex);
    }

}
