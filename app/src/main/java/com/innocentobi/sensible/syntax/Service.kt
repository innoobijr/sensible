package com.innocentobi.sensible.syntax

import com.innocentobi.sensible.actor.ActorSupervisor
import com.innocentobi.sensible.actor.MonitorMessage
import com.innocentobi.sensible.actor.ServiceMessage
import kotlinx.coroutines.CoroutineScope

abstract class Service<T, A>(private val CS: CoroutineScope) :
    ActorSupervisor where T : ServiceMessage, A : MonitorMessage {

}