package com.xfc.utils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xfc.util.DeviceID;
import com.xfc.util.DialogUtil;
import com.xfc.util.IntentUtil;
import com.xfc.util.LogUtil;
import com.xfc.util.MD5Util;
import com.xfc.util.SharedPreferencesUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button jump, dialog_open, dialog_remove, md;
    private DialogUtil dialogUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 进行跳转界面
         */
        jump = findViewById(R.id.jump);
        dialog_open = findViewById(R.id.dialog_open);
        dialog_remove = findViewById(R.id.dialog_remove);
        md = findViewById(R.id.md);
        dialog_open.setOnClickListener(MainActivity.this);
        dialog_remove.setOnClickListener(MainActivity.this);
        md.setOnClickListener(MainActivity.this);
        SharedPreferencesUtil.saveData(MainActivity.this, "name", "xfc");
        String name = (String) SharedPreferencesUtil.getData(MainActivity.this, "name", "fc");
        LogUtil.eLength("name", name);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 进行跳转到TextActivity界面,其他传参使用我就不一一介绍了
                 */
                IntentUtil.startActivity(MainActivity.this, TextActivity.class);
            }
        });
        getDeviceId();
        dialogUtil = new DialogUtil(MainActivity.this);

    }

    /**
     * 获取设备ID
     */
    private void getDeviceId() {
        LogUtil.eLength("设备id", DeviceID.getIMEI(MainActivity.this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /**
             * dialog界面展示
             */
            case R.id.dialog_open:
                dialogUtil.loadDialog();
                break;
            /**
             * dialog界面s移除
             */
            case R.id.dialog_remove:
                dialogUtil.removeDialog();
                break;
            /**
             * md5加密数据处理
             */
            case R.id.md:
                LogUtil.eLength("md5数据", MD5Util.md5("afck123"));
                break;
        }
    }
}
