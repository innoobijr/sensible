package com.innocentobi.sensible.syntax

import com.innocentobi.sensible.actor.MonitorMessage
import com.innocentobi.sensible.actor.ServiceMessage
import io.reactivex.subjects.PublishSubject

//Syntac for a bud
abstract class Bus<S, M> where S : ServiceMessage, M : MonitorMessage {
    abstract var serviceChannel : PublishSubject<S>
    abstract var monitorChannel : PublishSubject<M>
}

//Typeclass instance, now if the user wish to change the implementation
// Then they just need to provide a type instance
