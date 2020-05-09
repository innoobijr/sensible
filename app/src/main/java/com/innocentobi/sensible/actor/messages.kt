package com.innocentobi.sensible.actor

interface ServiceMessage
object StartCollection : ServiceMessage
object StopCollection : ServiceMessage
object ChangeCollectionParameters : ServiceMessage
object ChangeLocationContinuation : ServiceMessage
object KillMessage : ServiceMessage



interface MonitorMessage
sealed class ServiceLifecycleMessage : MonitorMessage
object ServiceCreated : ServiceLifecycleMessage()
object ServiceStarted : ServiceLifecycleMessage()
object ServiceDestroyed : ServiceLifecycleMessage()
object ReceiveStatus : MonitorMessage
object QueryStatus: MonitorMessage





