package com.innocentobi.sensible.instance.modules

import com.innocentobi.sensible.syntax.Module

object Modules {
//Hmmmm :)
// Is service Module a type class
// An each of these are instances of the typec lass ServiceDep
// ServiceModule[Location]
// ServiceModule[Database]
// ServiceModule[Logger] or in kotlin
// Kind<ServiceModule, _>
// Need a ForServiceModule --> this is just a programming exercise
// This benefit of doing this in a functional way is that
// someone can define a new ServiceDep instance and get all the benefits
// of a single error channel
// as long as the interface (module) defined a service

// It would ne a bit of work ont he users part to
// defined appropriate interfaces for service
// where service is just Async
// so whatever the service, it provides MonadError, or ApplicativeError
    interface DatabaseModule<T> : Module<T> {
        override val service: T
        companion object
    }

    interface LoggerModule<T> : Module<T> {
        override val service: T
        companion object

    }
}
