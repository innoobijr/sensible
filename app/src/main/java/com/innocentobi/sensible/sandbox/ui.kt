package com.innocentobi.sensible.sandbox

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.innocentobi.sensible.syntax.Environment

class SensibleService : Service(){

    lateinit var dep : Environment

    override fun onBind(p0: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    // Define new service as extension on property
    // You could even have a file where you save all the dependencies
    // Benefit is that this is resolved at compile time because you have to
    // specify the service. If in typing Kotlin can't find it, then it wont compile

    // To add a new dependency


    fun open(){
        dep.run{
        }

    }
}