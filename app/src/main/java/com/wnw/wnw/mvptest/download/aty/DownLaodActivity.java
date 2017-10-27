package com.wnw.wnw.mvptest.download.aty;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;


import com.wnw.wnw.mvptest.R;
import com.wnw.wnw.mvptest.download.DownInfo;
import com.wnw.wnw.mvptest.download.HttpDownManager;
import com.wnw.wnw.mvptest.download.HttpDownOnNextListener;
import com.wnw.wnw.mvptest.util.CommonUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 多任務下載
 */
public class DownLaodActivity extends AppCompatActivity {
    List<DownInfo> listData;
    HttpDownManager httpDownManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_laod);
        ButterKnife.bind(this);
        httpDownManager = HttpDownManager.getInstance();
        initResource();
    }

    /*数据*/
    private void initResource(){
        listData=new ArrayList<>();
        String[] downUrl=new String[]{
                "http://p.gdown.baidu.com/3c7bff928cdb62cfc8796530c509d64530d0ae09b2510df1da86f7640faaa970ff42a73661c176415af1cc3510b16df93b9acff7e933fed31687eae324a740f0240289c3e2f65f304186262ea61682af336bdef3ec4d70cf11ff6dc5234f534ddc996e033c2d9231b4b5da89d75ba8a40187e8d4a339a640b08f3d9923c3ba5c30f1e45206dfab91a446fbfc1652c75c83e533c14b8df3038ce1d94b402cfeaf80d160775b66433a589ab36eb22eb16fb35d73f01b366261893471e983786ed0dffa9ffee86a912ebc0c44a5c04cefb6d2b9135ad993a35cf33144604d5e256da9fee016c9a18cc69b102b3ddf7fc6f4f67804406843c57852651f73c5d0e63450fb38b8c0d22ecfdee29a293e213a871082050da306ca41522237773b392e1b0e0b1b7b97d782de8f76c594cabe8e0fa14ab5ea6a331f1929661b6ffa471ca7e21ddd43573d742a"};
        for (int i = 0; i < downUrl.length; i++) {
            File outputFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),
                    "test"+i + ".apk");
            DownInfo apkApi=new DownInfo(downUrl[i]);
            apkApi.setSavePath(outputFile.getAbsolutePath());
            listData.add(apkApi);
        }
    }

    @OnClick(R.id.btn1)
    void btn(){
        startDownload();
    }

    @OnClick(R.id.btn2)
    void btn2(){
        httpDownManager.pause(listData.get(0));
    }

    /*加载控件*/

    private void startDownload(){
        listData.get(0).setListener(httpDownOnNextListener);
        httpDownManager.startDown(listData.get(0));
    }

    HttpDownOnNextListener httpDownOnNextListener = new HttpDownOnNextListener() {
        @Override
        public void onNext(Object o) {
            DownInfo downInfo = (DownInfo)o;
            CommonUtil.printLogs("wnw", "down info " + downInfo.getCountLength() + " " + downInfo.getReadLength());
        }

        @Override
        public void onStart() {
            CommonUtil.printLogs("wnw", "提示:开始下载 ");
        }

        @Override
        public void onComplete() {
            CommonUtil.printLogs("wnw", "提示:下载完成 ");
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            CommonUtil.printLogs("wnw", "失败:"+e.toString());
        }

        @Override
        public void onStop() {
            super.onStop();
        }

        @Override
        public void updateProgress(long readLength, long countLength) {
            CommonUtil.printLogs("wnw", "提示:下载中 " + readLength + " " + countLength);
        }

        @Override
        public void onPause() {
            super.onPause();
        }
    };

}
