package com.xfc.util;

import android.text.Editable;
import android.widget.EditText;

/**
 * Created by xfc on 2017-02-28.
 */
// 给edittext控件控件设置光标在文字的后边
public class SelectionEnd {
    public static void setSelectionEnd(EditText editText) {
        Editable b = editText.getText();
        editText.setSelection(b.length());
    }

    public static void setEditText(EditText editText) {
        Editable b = editText.getText();
        editText.setSelection(b.length());
    }
}
