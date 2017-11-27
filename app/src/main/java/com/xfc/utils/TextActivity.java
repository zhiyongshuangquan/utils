package com.xfc.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xfc.util.AppManager;

/**
 * Created by xfc on 2017/11/27.
 */

public class TextActivity extends AppCompatActivity {
    private Button back;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        /**
         * 添加activity进入栈管理
         */
        AppManager.getAppManager().addActivity(this);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 界面返回
                 */
                AppManager.getAppManager().finishActivity(TextActivity.this);
            }
        });
    }
}
