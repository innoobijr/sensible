package com.innocentobi.sensible.instance.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.innocentobi.sensible.actor.ServiceMessage
import com.innocentobi.sensible.instance.modules.GoogleLocationModules
import com.innocentobi.sensible.instance.modules.Modules
import com.innocentobi.sensible.syntax.Environment
import kotlinx.coroutines.channels.SendChannel

abstract class SensibleService : Service(){

    //private var dep = Environment

    //fun runEnvironment(init: Environment.() -> Unit) = init

    // Provide the communication channel could call them sink and source
    // the sink which is where I'm sending info cannot be change by a subclass
    // the public function report force a public interface to this
    // the source which is the service subject can be used by the sub class to pass custom
    // subscription logic
    private val j : String = "Wew"
    protected val h : String = "wew"

    // Provide some actor
    abstract val actor : SendChannel<ServiceMessage>

    override fun onBind(p0: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // the default needs to be defined in the acivity or service using the module
    val GoogleLocationModules.FusedLocationModule.Companion.service : GoogleLocationModules.FusedLocationModule
            get() = object : GoogleLocationModules.FusedLocationModule {
        override val service: FusedLocationProviderClient =
            FusedLocationProviderClient(applicationContext)
        override val doOnLocationAvailable: (LocationResult) -> Unit = throw NotImplementedError()
        override val locationContinuation: LocationCallback = throw NotImplementedError()
        override val startLocationCollection: () -> Unit = throw NotImplementedError()
        override val stopLocationCollection: () -> Unit = throw NotImplementedError()
    }

    //the rest that doesnt require a context can be written in an object and imported into scope
    val Environment.loggerService : Modules.LoggerModule<String>
        get() = object : Modules.LoggerModule<String> {
            override val service: String
                get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        }

   //val task : Action = {this.locationService}

    //fun open(){
    //    task(Environment)
    //    val g = Environment.evaluate{task(this)}
//
  //  }



}

