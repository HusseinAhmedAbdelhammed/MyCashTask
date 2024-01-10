package com.example.yajhztask.app.ui.helpers

import android.Manifest
import android.content.Context
import pub.devrel.easypermissions.EasyPermissions

object HasPermission {
    fun hasLocationPermissions(context: Context) =
        EasyPermissions.hasPermissions(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

}


