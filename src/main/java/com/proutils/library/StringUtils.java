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
 * StringUtils
 */
public class StringUtils {

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    public static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }

    public static SpannableString changTextSpann(int textLen, String count, String addStr) {
        SpannableString string = null;
        if (isEmpty(count)) {
            return string;
        }
        string = new SpannableString(count + addStr);
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#FF8338"));
        string.setSpan(colorSpan1, 0, textLen, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return string;
    }


    public static SpannableString changTextSpannBlue(int textLen, String count, String addStr) {
        SpannableString string = null;
        if (isEmpty(count)) {
            return string;
        }
        string = new SpannableString(count + addStr);
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#007fff"));
        string.setSpan(colorSpan1, 0, textLen, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return string;
    }


    public static SpannableString changTextSpann(int textLen, String addStr01, String count, String addStr02) {
        SpannableString string = null;
        if (isEmpty(count)) {
            return string;
        }
        string = new SpannableString(addStr01 + count + addStr02);
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#FF4444"));
        string.setSpan(colorSpan1, addStr01.length(), textLen, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return string;
    }


    public static SpannableString changTextSpann02(int textLen, String addStr01, String count, String addStr02) {
        SpannableString string = null;
        if (isEmpty(count)) {
            return string;
        }
        string = new SpannableString(addStr01 + count + addStr02);
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#FF4444"));
        string.setSpan(colorSpan1, addStr01.length(), textLen - 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return string;
    }


    public static String[] convertStrToArray(String str) {
        String[] strArray = null;
        if (isEmpty(str)) {
            return strArray;
        }
        strArray = str.split("-");
        return strArray;
    }


    /**
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
     */
    public static int getStringLenth(String s) {
        return isEmpty(s) || "null".equals(s) ? 0 : s.length();
    }

    /**
     *
     */
    public static boolean getIsStringOk(Context context,String s, int small, int big) {
        int stringLength = s.length();
        if (stringLength >= small && stringLength <= big) {
            return true;
        } else {
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
     *
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
     *
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
     *
     *
     * @param str
     * @return
     */
    public static boolean checkString(String str) {
        boolean res = false;
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
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

    public static boolean checkChar(char ch) {
        if ((ch + "").getBytes().length == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param s
     * @return
     */
    public static int getInteger(String s) {
        return isEmpty(s) ? 0 : Integer.parseInt(s);
    }

    /**
     *
     * @param s
     * @return
     */
    public static String getNumString(String s) {
        return isEmpty(s) || "null".equals(s) ? "0" : s;
    }


    /**
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
}
