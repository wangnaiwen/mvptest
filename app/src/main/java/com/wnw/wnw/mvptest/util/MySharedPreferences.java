package com.wnw.wnw.mvptest.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.JsonParser;
import com.wnw.wnw.mvptest.bean.User;


public class MySharedPreferences {
    private static SharedPreferences mPreferences;
    private static MySharedPreferences instance;
    private static SharedPreferences.Editor mEditor;
    private static final String name = "cro_user_sp";

    private static final String KEY_LOCATION = "location";
    private static final String KEY_USER = "user";
    private static final String KEY_PWD = "password";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_CITY_LIST = "cityList";
    private static final String KEY_BRAND_LIST = "brandList";
    private static final String KEY_MY_BRAND = "myBrand";
    private static final String KEY_MY_CARTYPE = "myCartType";
    private static final String KEY_VOICE_OPEN = "openVoice";
    private static final String KEY_LAST_USER_NAME = "lastUserName";

    private static final String KEY_LSAT_LOAD_PATCH = "patch";

    /**
     * 构造方法
     *
     * @param context
     */
    private MySharedPreferences(Context context) {
        mPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

    public static MySharedPreferences getInstance(Context context) {

        if (instance == null) {
            synchronized (MySharedPreferences.class) {
                if (instance == null) {
                    instance = new MySharedPreferences(context);
                }
            }
        }
        return instance;
    }

    /**
     * 清空数据
     */
    public void clear() {
        mEditor.clear().commit();
    }


    public void saveUser(User user) {
        setStringValue(KEY_USER, JsonUtil.toJson(user).toString());
    }

    public void savePwd(String pwd) {
        setStringValue(KEY_PWD, pwd);
    }

    public void saveToken(String token) {
        setStringValue(KEY_TOKEN, token);
    }

    public void saveCityList(String json) {
        setStringValue(KEY_CITY_LIST, json);
    }

    public void saveBrandList(String json) {
        setStringValue(KEY_BRAND_LIST, json);
    }

    public void saveVoiceSelect(boolean isOpen) {
        setBooleanValue(KEY_VOICE_OPEN, isOpen);
    }

    public void saveLastUserName(String userName) {
        setStringValue(KEY_LAST_USER_NAME, userName);
    }

    public String getLastUserName() {
        return getStringValue(KEY_LAST_USER_NAME, "");
    }

    public boolean getVoiceSelect() {
        return getBooleanValue(KEY_VOICE_OPEN, true);
    }

    public String getToken() {
        return getStringValue(KEY_TOKEN, "");
    }

    public String getPwd() {
        return getStringValue(KEY_PWD, "");
    }

    public User getUser() {
        String json = getStringValue(KEY_USER, "");
        if (TextUtils.isEmpty(json)) {
            return null;
        }

        return JsonUtil.fromJson(new JsonParser().parse(json), User.class);
    }


    public void setStringValue(String key, String value) {
        mEditor.putString(key, value);
        mEditor.apply();
    }

    public String getStringValue(String key, String defValue) {
        return mPreferences.getString(key, defValue);
    }

    public void setBooleanValue(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.apply();
    }

    public boolean getBooleanValue(String key, boolean defValue) {
        return mPreferences.getBoolean(key, defValue);
    }

    public void deleteBrandAndType() {
        mEditor.remove(KEY_MY_BRAND);
        mEditor.remove(KEY_MY_CARTYPE);
        mEditor.apply();
    }

    public void saveLastLoadPatchTime(long value) {
        mEditor.putLong(KEY_LSAT_LOAD_PATCH, value);
        mEditor.apply();
    }

    public long getLastLoadPatchTime() {
        return mPreferences.getLong(KEY_LSAT_LOAD_PATCH, 0);
    }
}
