package com.smarthost.util;

import android.app.Activity;
import android.content.Intent;

import com.smarthost.AppraiseActivity;
import com.smarthost.ListingsActivity;

public class DrawerUtils {

    public static final float PARALAX_OFFSET = 200.0f;

    public static Runnable buildLaunchRunnable(final Activity context, final int which) {
        return new Runnable() {
            @Override
            public void run() {
                Intent intent = null;
                switch (which) {
                    case Navigation.ID_APPRAISALS:
                        intent = AppraiseActivity.getLaunchIntent(context);
                        break;

                    case Navigation.ID_LISTINGS:
                        intent = ListingsActivity.getLaunchIntent(context);
                        break;
                }

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

                context.finish();
                context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        };
    }

}