package com.innocentobi.sensible.syntax

import com.innocentobi.sensible.actor.ActorSupervisor
import com.innocentobi.sensible.actor.MonitorMessage
import com.innocentobi.sensible.actor.ServiceMessage
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.SendChannel

abstract class Service<T, A>(private val CS: CoroutineScope) :
    ActorSupervisor where T : ServiceMessage, A : MonitorMessage {

    // The source is where the monitor is receiving messages its the same for all monitors
    abstract val bus : Bus<T, A>
    abstract val actor : SendChannel<A>
    // The sink is where the monitor is sending messages, i.e the subject. This should reference the bus

    private val source : PublishSubject<T> = bus.serviceChannel
    private val sink : PublishSubject<A> = bus.monitorChannel

}

