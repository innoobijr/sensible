package com.innocentobi.sensible.instance.bus

import com.innocentobi.sensible.actor.MonitorMessage
import com.innocentobi.sensible.actor.ServiceMessage
import com.innocentobi.sensible.syntax.Bus
import io.reactivex.subjects.PublishSubject

abstract class SensibleBus<S, M>: Bus<S, M>  where S : ServiceMessage, M : MonitorMessage {

    override val monitorChannel: PublishSubject<M> = PublishSubject.create()
    override val serviceChannel: PublishSubject<S> = PublishSubject.create()

}

