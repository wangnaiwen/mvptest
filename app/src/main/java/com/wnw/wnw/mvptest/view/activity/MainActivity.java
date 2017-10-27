package com.wnw.wnw.mvptest.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.wnw.wnw.mvptest.R;
import com.wnw.wnw.mvptest.view.fragment.TestFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * @author wnw
 *
 * @date 2017/10/25 0025 15:45
 *
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fragment)
    FrameLayout frameLayout;

    private TestFragment testFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        testFragment = new TestFragment();
    }

    @OnClick(R.id.fragment)
    void transformFag(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, testFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
