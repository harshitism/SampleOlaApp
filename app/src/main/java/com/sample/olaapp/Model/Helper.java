
package com.sample.olaapp.Model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.util.LruCache;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Helper {

    public static void setIntegerSharedPreference(String key, int value, Context context) {

        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getIntegerSharedPreference(String key, Context context) {
        SharedPreferences settings = context.getSharedPreferences(Constant.MY_PREFERENCES, Context.MODE_PRIVATE);
        return settings.getInt(key, 0);
    }

    public static void setStringSharedPreference(String key, String value, Context context) {

        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.commit();
    }

    public static String getStringSharedPreference(String key, Context context) {
        SharedPreferences settings = context.getSharedPreferences(Constant.MY_PREFERENCES, Context.MODE_PRIVATE);
        return settings.getString(key, "");
    }

    public static void removeSharedPreference(String key, Context context) {

        SharedPreferences.Editor editor = getEditor(context);
        editor.remove(key);
        editor.commit();
    }

    public static void deleteAllUserData(Context context) {

        SharedPreferences.Editor editor = getEditor(context);
        editor.apply();

        SharedPreferences.Editor pref_reg = context.getApplicationContext().getSharedPreferences("BDFREG2", 0).edit();
        pref_reg.remove("registration_id");
        pref_reg.apply();

    }

    public static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences settings = context.getSharedPreferences(Constant.MY_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        return editor;
    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    static int cacheSize = 4 * 1024 * 1024; // 4MiB
    static LruCache<String, String> cache = new LruCache<>(cacheSize);


    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static boolean isNetworkAvailable(Context ctx) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public static void showAlertDialog(Context context, String title, String message, String ptext, DialogInterface.OnClickListener plistener, String ntext, DialogInterface.OnClickListener nlistener) {
        if (context != null) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle(title);
            alertDialogBuilder.setMessage(message);
            alertDialogBuilder.setPositiveButton(ptext, plistener);
            alertDialogBuilder.setNegativeButton(ntext, nlistener);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.setCancelable(false);
            alertDialog.show();
        }

    }


}
