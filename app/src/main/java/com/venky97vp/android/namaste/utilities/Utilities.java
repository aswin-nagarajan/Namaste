package com.venky97vp.android.namaste.utilities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import java.net.InetAddress;

/**
 * Created by venky on 13-10-2017.
 */

public class Utilities {
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showSnack(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    public static void shareMessage(Context context, String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Sharing URL");
        intent.putExtra(Intent.EXTRA_TEXT, message);
//        context.startActivity(Intent.createChooser(intent, title));
        context.startActivity(intent);
    }

    public static boolean isEmptyOrNull(String... messages) {
        for (String message : messages) {
            boolean b = message == null || message.equals("");
            if (b)
                return true;
        }
        return false;
    }

    public static boolean isInternetAvailable() {
        //TODO: Need changes
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            return !ipAddr.toString().equals("");
        } catch (Exception e) {
            return false;
        }
    }
}
