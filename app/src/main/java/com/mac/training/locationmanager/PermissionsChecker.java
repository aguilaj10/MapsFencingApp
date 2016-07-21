package com.mac.training.locationmanager;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * Created by admin on 7/20/2016.
 */
public class PermissionsChecker {
    private static final String TAG = PermissionsChecker.class.getName();

    public static void permissionChecker(Activity act, String permission, int code){
        if (ContextCompat.checkSelfPermission(act, permission) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(act, Manifest.permission.READ_SMS)) {
                Log.d(TAG, "onCreate: " + "Show explanation");
                ActivityCompat.requestPermissions(act, new String[]{permission}, code);
            } else {
                ActivityCompat.requestPermissions(act, new String[]{permission}, code);
            }
        } else {
            Log.d(TAG, "onCreate: " + "Permission already granted!");
        }
    }
}
