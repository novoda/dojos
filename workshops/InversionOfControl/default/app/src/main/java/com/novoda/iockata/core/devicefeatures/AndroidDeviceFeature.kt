package com.novoda.iockata.core.devicefeatures


class AndroidDeviceFeature : DeviceFeature {

    override fun canToast() = false

    override fun canDial() = true

    override fun canShootPhoto() = true

    override fun canGoOnline() = true
}

