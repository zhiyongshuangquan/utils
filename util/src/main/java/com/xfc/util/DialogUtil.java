package com.xfc.util;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by xfc on 2016-08-31.
 */
//dialog设置工具类
public class DialogUtil {
    private Context context;
    private View view;
    private Dialog viewDialog;
    private Dialog viewBottomDialog;
    private View viewbottom;
    private int bottom;
    private Dialog progressDialog;
    private Dialog dialogLogin;

    public DialogUtil(Context context) {
        this.context = context;
    }

    public DialogUtil(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    public DialogUtil(Context context, View viewbottom, int bottom) {
        this.context = context;
        this.viewbottom = viewbottom;
        this.bottom = bottom;
    }

    /*用于加载progressbar dialog*/
    public Dialog loadDialog() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialog_loading, null);// 得到加载view
        LinearLayout layout = (LinearLayout) v
                .findViewById(R.id.dialog_loading_view);// 加载布局
        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
        tipTextView.setText("加载中");// 设置加载信息
        progressDialog = new Dialog(context, R.style.MyDialogStyle);// 创建自定义样式dialog
        progressDialog.setCancelable(true); // 是否可以按“返回键”消失
        progressDialog.setCanceledOnTouchOutside(false); // 点击加载框以外的区域
        progressDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
        /**
         *将显示Dialog的方法封装在这里面
         */
        Window window = progressDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);
        window.setWindowAnimations(R.style.PopWindowAnimStyle);
        progressDialog.show();
        return progressDialog;
    }

    //用于自定义布局dialog加载
    public Dialog loadLogindialog() {
        //判断是否创建过
        if (dialogLogin == null) {
            dialogLogin = new Dialog(context);
        }
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.checklogin, null);// 得到加载view
        Button qxbutton_id = v.findViewById(R.id.qxbutton_id);
        Button checkbutton_id = v.findViewById(R.id.checkbutton_id);
        qxbutton_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeloginDialog();
            }
        });
        checkbutton_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeloginDialog();
            }
        });
        dialogLogin.setContentView(v);
        try {
            int dividerID = context.getResources().getIdentifier("android:id/titleDivider", null, null);
            View divider = dialogLogin.findViewById(dividerID);
            divider.setBackgroundColor(Color.TRANSPARENT);
        } catch (Exception e) {
            //上面的代码，是用来去除Holo主题的蓝色线条
            e.printStackTrace();
        }
        dialogLogin.setCanceledOnTouchOutside(true);
        dialogLogin.getWindow().setBackgroundDrawable(new ColorDrawable());
        dialogLogin.show();
        return dialogLogin;
    }

    //用于自定义布局dialog加载
    public Dialog loadViewdialog() {
        //判断是否创建过
        if (viewDialog == null) {
            viewDialog = new Dialog(context);
        }
        viewDialog.setContentView(view);
        viewDialog.setCanceledOnTouchOutside(true);
        try {
            int dividerID = context.getResources().getIdentifier("android:id/titleDivider", null, null);
            View divider = viewDialog.findViewById(dividerID);
            divider.setBackgroundColor(Color.TRANSPARENT);
        } catch (Exception e) {
            //上面的代码，是用来去除Holo主题的蓝色线条
            e.printStackTrace();
        }
        viewDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        viewDialog.show();
        return viewDialog;
    }

    //用于自定义布局dialog加载
    public Dialog loadViewdialogtwo() {
        //判断是否创建过
        if (viewDialog == null) {
            viewDialog = new Dialog(context);
        }
        viewDialog.setContentView(view);
        viewDialog.setCanceledOnTouchOutside(false);
        try {
            int dividerID = context.getResources().getIdentifier("android:id/titleDivider", null, null);
            View divider = viewDialog.findViewById(dividerID);
            divider.setBackgroundColor(Color.TRANSPARENT);
        } catch (Exception e) {
            //上面的代码，是用来去除Holo主题的蓝色线条
            e.printStackTrace();
        }
        viewDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        viewDialog.show();
        return viewDialog;
    }

    //设置位于底部的dialog从下到上弹出布局
    public Dialog loadViewBottomdialog() {
        //判断是否创建过
        if (viewBottomDialog == null) {
            viewBottomDialog = new AlertDialog.Builder(context).create();
        }
        viewBottomDialog.setCanceledOnTouchOutside(true);
        viewBottomDialog.show();
        // 设置dialog没有title
        viewBottomDialog.setContentView(viewbottom, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        Window window = viewBottomDialog.getWindow();
        window.setWindowAnimations(R.style.mystyle);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 可以在此设置显示动画
        WindowManager.LayoutParams wl = window.getAttributes();
        //设置dialog背景是否变暗
        if (bottom == 2) {
            wl.dimAmount = 0f;
            window.setAttributes(wl);
        }
        wl.x = 0;
        wl.y = ((Activity) context).getWindowManager().getDefaultDisplay().getHeight();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 设置显示位置
        viewBottomDialog.onWindowAttributesChanged(wl);
        // 设置弹出的动画效果
        return viewBottomDialog;
    }

    /*用于自定义布局dialog移除*/
    public void removeviewDialog() {
        if (viewDialog != null) {
            if (viewDialog.isShowing()) {
                viewDialog.dismiss();
            }
        }
    }

    /*用于自定义布局dialog移除*/
    public void removeloginDialog() {
        if (dialogLogin != null) {
            if (dialogLogin.isShowing()) {
                dialogLogin.dismiss();
            }
        }
    }

    /*用于自定义底部布局dialog移除*/
    public void removeviewBottomDialog() {
        if (viewBottomDialog != null) {
            if (viewBottomDialog.isShowing()) {
                viewBottomDialog.dismiss();
            }
        }
    }

    /*网络加载dialog移除*/
    public void removeDialog() {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }
}
