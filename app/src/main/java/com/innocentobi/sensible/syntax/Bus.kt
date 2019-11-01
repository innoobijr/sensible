package com.innocentobi.sensible.syntax

import com.innocentobi.sensible.actor.MonitorMessage
import com.innocentobi.sensible.actor.ServiceMessage
import io.reactivex.subjects.PublishSubject

//Syntac for a bud
interface Bus<S, M> where S : ServiceMessage, M : MonitorMessage {
    val serviceChannel : PublishSubject<S>
    val monitorChannel : PublishSubject<M>
}

//Typeclass instance, now if the user wish to change the implementation
// Then they just need to provide a type instance
