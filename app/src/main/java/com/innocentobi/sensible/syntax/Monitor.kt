package com.innocentobi.sensible.syntax

import com.innocentobi.sensible.actor.ActorSupervisor
import com.innocentobi.sensible.actor.MonitorMessage
import com.innocentobi.sensible.actor.ServiceMessage
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.launch
import java.lang.Exception


abstract class Monitor<T, A>(private val CS: CoroutineScope) : ActorSupervisor where T : ServiceMessage, A : MonitorMessage {

    //State[S, Boolean]
    var isMonitoring : Boolean = false
        private set
    // The source is where the monitor is receiving messages its the same for all monitors
    abstract val bus : Bus<T, A>
    abstract val actor : SendChannel<A>

    // The sink is where the monitor is sending messages, i.e the subject. This should reference the bus
    private val sink : PublishSubject<T> = bus.serviceChannel
    private val source : PublishSubject<A> = bus.monitorChannel

    fun monitor(errorCallback : (Throwable) -> Unit, completionCallback : () -> Unit) : Unit{
        // This should be a bracket with resource finalization --> this should also not be done int
        // abstract class
        isMonitoring = true

        // Single error channel with FlatMap
        // Move concern of subscription out of func
        // Should be:
        //  1. registerListener
        //  2. mutateState
        //  3. handleError
        try {
            source.subscribeBy(
                onNext = { msg ->
                    CS.launch {
                        actor.send(msg)
                    }
                },
                onComplete = {completionCallback; isMonitoring = false},
                onError = errorCallback
            )
        } catch (e: Exception){
            e.printStackTrace()
            isMonitoring = false
        }
    }

    fun tell(msg: T) =
        sink.onNext(msg)
}