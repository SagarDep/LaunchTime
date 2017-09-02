package com.quaap.launchtime.components;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;

/**
 * Copyright (C) 2017   Tom Kliethermes
 *
 * This file is part of LaunchTime and is is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 */
public class MsgBox {


    public static void show(Context context, String title, String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public static void showNewsMessage(final Context context, SharedPreferences prefs) {
        final int newsnum = 62;
        final int news = prefs.getInt("seennews", 0);
        if (news<newsnum) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    show(context,"What's new in version 0.6.x!",
                            " * Icon packs.\n" +
                            " * Customize icons and labels.\n" +
                            " * Built-in themes.\n" +
                            " * Android 7.1 shortcut actions.\n" +
                            " * Machine translations for German, French, Spanish, and others (expert translations wanted!).\n\n" +
                            "Go to Settings->Help for links to submit feature requests, bugs, and pull requests."
                    );

                }
            }, 3000);
            prefs.edit().putInt("seennews", newsnum).apply();
        }

    }
}