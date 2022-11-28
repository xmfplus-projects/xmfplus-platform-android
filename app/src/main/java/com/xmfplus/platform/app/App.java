package com.xmfplus.platform.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.AppUtils;
import com.kongzue.dialogx.DialogX;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
        initDialogX();
    }


    private void initARouter () {
        if (AppUtils.isAppDebug()) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    private void initDialogX() {
        DialogX.init(this);
    }
}
