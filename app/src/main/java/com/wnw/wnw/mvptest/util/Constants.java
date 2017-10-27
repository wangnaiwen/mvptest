package com.wnw.wnw.mvptest.util;

import android.os.Environment;

import java.io.File;

/**
 * Created by yue on 17/5/31.
 */

public class Constants {
    public static boolean IS_LOG_ON = true;
    //设置定位间隔时间(ms)
    public static int AMAP_LOCATION_INTERVAL = 30 * 1000;
    public static String MSC_APPID = "=594caabf";

    public static int COUNT_PER_PAGE_ARTICLE = 10;

    public static final String UPDATED_AT = "updatedAt";
    public static final String INTENT_KEY = getPrefixConstant("intent_key");
    public static final String INTENT_VALUE = getPrefixConstant("intent_value");

    public static final String[] azArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /**
     * IM
     */
    private static final String LEANMESSAGE_CONSTANTS_PREFIX = "com.avoscloud.leanchatlib.";
    public static final String MESSAGE_ATTACH_KEY_FILE_ID = "fileId";
    public static final String MESSAGE_ATTACH_KEY_NICKNAME = "nickName";
    public static final String MESSAGE_ATTACH_KEY_IMG_MODEL = "imgModel";


    public static int RESTART_APP_TIME = 5*1000;                   //设置AlarmManager的重启时间：5 s
    public static int DELAY_KILL_PROCESS_TIME = 4*1000;            //延时杀死进程的时间
    public static int MAX_FIND_HOTFIX_PATCH_TIMES = 144*60*1000;  //查询下一个patch包相隔的时间间隔：ms


    /**
     * 语音时长上限,in ms
     */
    public static final int MAX_VOICE_TIME = 60 * 1000;

    public static String getPrefixConstant(String str) {
        return LEANMESSAGE_CONSTANTS_PREFIX + str;
    }

    /**
     * 本地存储目录
     */
    public static final String BASE_PATH = Environment
            .getExternalStorageDirectory().getAbsolutePath() + File.separator;
    public static final String FOLDER_GETON = BASE_PATH + "CROFix" + File.separator;

    /**
     * 本地存储目录————二级目录
     */
    public static final String FOLDER_DOWNLOAD = FOLDER_GETON + "download" + File.separator;
    public static final String FOLDER_CACHE = FOLDER_GETON + "cache";
    public static final String FOLDER_PHOTO = FOLDER_GETON + "photo" + File.separator;

    /**
     * 本地存储目录————三级目录(photo)
     */
    public static final String FOLDER_PHOTO_CAMERA = FOLDER_PHOTO + "camera" + File.separator;
    public static final String FOLDER_PHOTO_CUT = FOLDER_PHOTO + "cut" + File.separator;

    /**
     * TEST im
     */
//    public static final String MY_CLIENT_ID = "clientA";
//    public static final String OTHERS_CLIENT_ID = "clientB";

    /**
     * 广播action
     */
    public static final String ACTION_NEW_ORDER = "action_new_order";

    public static final String DATEFORMAT_FORMAL = "yyyy-MM-dd HH:mm:ss";

    //七牛图片baseUrl
    public static final String QINIU_PIC_BASE = "http://otfl590no.bkt.clouddn.com/";

    public static final String ROLE_FLAG = "3";

    public static final String RSA_PUBLIC_KEY =
            "MIIEIjANBgkqhkiG9w0BAQEFAAOCBA8AMIIECgKCBAEAsnqFPJQM0x3RhAbwpKEP\n" +
                    "TsfC8mE1gze5iczGbuosVrIlp5q9Ifawp/WHk/ji4q/Uz07Ivkuvm+hbhLB1Jdqq\n" +
                    "4stuLmg9cxK9HWKs6nU4QqpceEwE6Imiz38bCPLZU5geYjnBGPBgu7wY9PD/dSwr\n" +
                    "xhIB/FuKGtocM/100VfVLYFs7/wAK/WhkGLBPo6YoS3h8+DT9Fqv0jDhcvYYk/IW\n" +
                    "LEegO3qCjIl0KCSGSdHvJp5Xrg/BDSpA2oYL+2j9OPPfyfRqUKP4seDPEpFfCnhS\n" +
                    "4tx/LfBrJruKf4ztVfcDojjZWztS+Tk7a83/i6USPxbYfqMH0pdKplFVL0x/S2KR\n" +
                    "yqU85E4chohtixMtrE9TPqk/xuqb/NFV8bxGPY2YFH4faB9EJrS9QF/vAxRJbR2N\n" +
                    "OIbubg3JotkFSOAnAwcg8pjz0PKlP0HeQ2vTtPxzGm2FropVWTPsdm5G1Dlj1nVM\n" +
                    "8Ox0CZKZeRsdjsyXLAwMZqKNEUmsneAYDefM9202I+pLnI4eeiAyUEbzkbAxWtQ1\n" +
                    "HxjWLaoX7RNMDVdFlmx7OOFME14njfr+Rn+gLs7b3YKSCW5I2hfuJBaL2tXgy+hJ\n" +
                    "FjtCO006+Xj54ct+NXJDHSqdCAxhKvIy5UEqOPIfKZeiaEvuYNvDjVL8DTG7lgIe\n" +
                    "nwUgvD0+fZESitWlifsuzMEdXMTpek1GJC5UMX+arZX95A+X5KAE3U13zRBYK6Ph\n" +
                    "avG0Iqac0yKIILGX+2zI6PN9st533fzSA2I1paS5IyYsMfqdRO6ET0m7W1iTN6S9\n" +
                    "ekdFX5cZDIgmfuRBLuUgoSqBygPW/QivryyHrNgO3CPthHg7u5Gdm4gGHOAc3Pwi\n" +
                    "a8MlDzxKEU1bw1X4Mk0vzg9S1q+pLToa2BOi2TrSecXMGVCizsxysfggKUhrbmE3\n" +
                    "6pMXhgq5QORZBUfzP2MGlYgvh+c1+2p0Rh1QZOY/i+PS5uulP7jWvAz/5osyZLZn\n" +
                    "I5eNw9znGdesP9CXeU21V6V/QgRwauywC3WD0Bzo5WsxHQAxkFSt2DY29qsPvgpM\n" +
                    "8cRwWWw6+Qudy/znGb7qyF2gO9XjiuUNizf22DPi2T7em7OL30BM8qY8n+sqpXQO\n" +
                    "/7WNIDPm+dTd2rEQ7eEjIYKVV2ueEjCZyWdpt82kfftwOqsbWhupFBt8myvtWBub\n" +
                    "6xm76muT5t4aXGWmekxpIQNAXIE8Z247DKr5pXYF7ZkGBtDsNRlzLPZSnilKZafi\n" +
                    "+x9UW7fkIPqSXMUZK0vbumA5yBNO3rK92G6fiLiZttu65QgcjTXUGHc/fw0iSdaP\n" +
                    "frFZXe+TEMzLBbgPXPKI7wHxjrBPyV1Z/XNeGqWuTdF/ZkOkEDZMdfk+j0Iub+xm\n" +
                    "fQIDAQAB";

    /**
     * web页面URL
     */
    public static final String WEB_BASE_URL = "http://consult.xiubike.com/";
    public static final String WEB_ENCASH_PROTOCAL = WEB_BASE_URL + "withdrawhelp";//提现帮助
    public static final String WEB_REGIST_PROTOCAL = WEB_BASE_URL + "Xboer";//注册协议
    public static final String WEB_ABOUT = WEB_BASE_URL + "UsX";//关于我们
    public static final String WEB_LEGAL = WEB_BASE_URL + "Xglawtel";//法律条款

}
