package com.wnw.wnw.mvptest.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by yue on 17/5/31.
 */

public class CommonUtil {
    public static int parseInt(String str) {
        try {
            return (int) Float.parseFloat(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void printLogs(String tag, String logs) {
        if (Constants.IS_LOG_ON) {
            Log.e(tag, "======" + logs);
        }
    }

    private static long lastClickTime;

    public static boolean isFastClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 1000) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public static void hideInputManager(Context ct) {
        try {
            ((InputMethodManager) ct.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(((Activity) ct)
                    .getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showInputManager(Context ct) {
        InputMethodManager imm = (InputMethodManager) ct.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
    }

    public static int dpToPx(Context context, int dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * @return 一个view所属的activity
     */
    public static Activity getActivity(View view) {
        Context ctx = view.getContext();
        if (ctx instanceof Activity) {
            return (Activity) ctx;
        }
        return null;
    }

    public static boolean isApplicationBroughtToBackground(final Context context) {
        if (context == null){
            return true;
        }

        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean validatePhoneNum(String phone) {
        String telRegex = "[1][3578]\\d{9}";
        Pattern pattern = Pattern.compile(telRegex);
        Matcher matcher = pattern.matcher(phone);
        boolean b = matcher.matches();
        if (!b) {
            return false;
        }
        return true;
    }

    public static boolean validatePW(String password) {
        String telRegex = "([a-zA-Z0-9]|[._]){6,16}";
        Pattern pattern = Pattern.compile(telRegex);
        Matcher matcher = pattern.matcher(password);
        boolean b = matcher.matches();
        if (!b) {
            return false;
        }
        return true;
    }

    /**
     * @param carNum 15位身份证
     * @return
     */
    public static boolean validateIDCardcarNum15(String carNum) {
        String telRegex = "^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$";
        Pattern pattern = Pattern.compile(telRegex);
        Matcher matcher = pattern.matcher(carNum);
        boolean b = matcher.matches();
        if (!b) {
            return false;
        }
        return true;
    }

    /**
     * @param carNum 18位身份证
     * @return
     */
    public static boolean validateIDCardcarNum18(String carNum) {
        String telRegex = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        Pattern pattern = Pattern.compile(telRegex);
        Matcher matcher = pattern.matcher(carNum);
        boolean b = matcher.matches();
        if (!b) {
            return false;
        }
        return true;
    }

    /**
     * 获取版本code
     *
     * */
    public static int getVersionCode(Context context){
        try{
            String pkName = context.getPackageName();
            int versionCode = context.getPackageManager().getPackageInfo(pkName, 0).versionCode;
            return versionCode;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static String getVersionName(Context context) {
        try {
            String pkName = context.getPackageName();
            String versionName = context.getPackageManager().getPackageInfo(
                    pkName, 0).versionName;
//            int versionCode = context.getPackageManager()
//                    .getPackageInfo(pkName, 0).versionCode;
            return versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPrice(String priceCount) {
        if (TextUtils.isEmpty(priceCount)){
            return "";
        }

        double pri = Double.parseDouble(priceCount) / 100;
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(pri);
    }

    public static Bitmap getBankIcon(Context context, String imgName) {
        AssetManager am = context.getResources().getAssets();
        InputStream is = null;
        try {
            is = am.open("bank_logo/" + imgName);
            return BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static String getPhone(String phone) {
        StringBuilder sb = new StringBuilder();
        sb.append(phone.substring(0, 3));
        sb.append("****");
        sb.append(phone.substring(phone.length() - 4, phone.length()));
        return sb.toString();
    }

    /**
     *
     * 获取当前时间的天
     * */
    public static int getDayOfToday(){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.DATE);
    }



    public static int getNowYear() {
        long time = System.currentTimeMillis();

        Calendar calender = Calendar.getInstance();
        calender.setTimeInMillis(time);

        return calender.get(Calendar.YEAR);
    }

    public static int getNowMonth() {
        long time = System.currentTimeMillis();

        Calendar calender = Calendar.getInstance();
        calender.setTimeInMillis(time);

        int month = calender.get(Calendar.MONTH);

        return month + 1;
    }

    public static int getNowDay() {
        long time = System.currentTimeMillis();

        Calendar calender = Calendar.getInstance();
        calender.setTimeInMillis(time);

        return calender.get(Calendar.DAY_OF_MONTH);
    }

    public static String getDate() {
        long time = System.currentTimeMillis();

        Calendar calender = Calendar.getInstance();
        calender.setTimeInMillis(time);
        int month = calender.get(Calendar.MONTH) + 1;

        return calender.get(Calendar.YEAR)+"-" + month +"-"+calender.get(Calendar.DAY_OF_MONTH);
    }
}
