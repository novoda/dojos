package com.novoda.iockata.core.devicefeatures

interface DeviceFeature {

    fun canDial(): Boolean
    fun canShootPhoto(): Boolean
    fun canGoOnline(): Boolean
    fun canToast():Boolean

}
