package com.xmfplus.platform.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xmfplus.platform.R;

@Route(path = "/activity/splash")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ARouter.getInstance().build("/activity/main").navigation();
    }


    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}