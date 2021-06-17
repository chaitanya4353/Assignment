package com.assignment.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.assignment.R;
import com.google.android.material.snackbar.Snackbar;


public class CommonMethods {

    Activity mActivity;


    public CommonMethods(Activity activity) {
        mActivity = activity;
    }

    public void hideSoftKeyboard() {

        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = mActivity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(mActivity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    public void showSnackBar(Context context,View view, String sdf) {

        Snackbar snackbar=Snackbar.make(view, sdf, Snackbar.LENGTH_LONG);
        View sbview = snackbar.getView();
        sbview.setBackgroundColor(context.getColor(R.color.purple_700));
        TextView textView = sbview.findViewById(R.id.snackbar_text);
        textView.setTextColor(context.getColor(R.color.white));

        snackbar.show();

    }

}
