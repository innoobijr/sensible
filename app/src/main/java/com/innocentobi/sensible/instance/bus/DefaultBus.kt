package com.innocentobi.sensible.instance.bus

import com.innocentobi.sensible.actor.MonitorMessage
import com.innocentobi.sensible.actor.ServiceMessage
import com.innocentobi.sensible.syntax.Bus
import io.reactivex.subjects.PublishSubject

object DefaultBus : Bus<ServiceMessage, MonitorMessage>() {

    override val monitorChannel: PublishSubject<MonitorMessage> = PublishSubject.create()
    override val serviceChannel: PublishSubject<ServiceMessage> = PublishSubject.create()

}