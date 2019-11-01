package com.innocentobi.sensible.instance.modules

import com.innocentobi.sensible.syntax.Module
import com.google.android.gms.location.*

object GoogleLocationModules {

    interface LocationModule<T> : Module<T> {

        override val service: T
    }

    interface FusedLocationModule :
        LocationModule<FusedLocationProviderClient> {
        override val service: FusedLocationProviderClient

        val locationContinuation : LocationCallback
        val doOnLocationAvailable : (LocationResult) -> Unit
        val startLocationCollection: () -> Unit
        val stopLocationCollection: () -> Unit

        companion object

    }
}