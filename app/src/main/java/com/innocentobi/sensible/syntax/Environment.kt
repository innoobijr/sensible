package com.innocentobi.sensible.syntax

interface Environment {
    // you can inject into the environment with an extension function
    // Environment is check on compile
    // Best way is to write all the deps in an object, then import that object in the project where need
    // since it is an object, there is only only one instance
    // will need a way to handle the deps being use from multiple thread
    // so each object an have a lock -> which is the usually way
    // or dep implementation is action based and environment has an actor that is exposed to received commands
    // for callers.
    // of the implementation handles it concurrency needs explicitly
    // this runways away fo cakey patterns and makes the task of inject dependencys as just specifying
    // functions and interfaces to be called
    // There is a way of maybe injecting the environment into the application on start and having that
    // static object instance contain the dependencies needed
    // The big issues is about the thread-safety of this design. Right now there are no guarantees.
    operator fun<T> invoke(init: Environment.() -> T) = init(this)
    /**
     * This is the stuff we need for have the basic functionality of a LocationService
     * We inject this into the Service. We inject this into the service onStart or onBind.
     * This means that we need a sensible wrapper on the Service that changes the implementation
     *
     * Other appraoch was using a companion object on the interface
     *
     * **/
    //val locationService : GoogleLocationModules.FusedLocationModule
    //val locationService = object : LocationModule<Int> by LocationModule {}
    //val databaseService : DatabaseModule
    fun<T> add(x:T, y: T) where T : Int = x + y

    // Super interesting. This might be a function of my need to replicate certain style
    // but in this call bind or evaluate were attempting to do a simiple thing. Call or thread a
    // a computation through a context. If I appropriately configure the spec
    // I woould thrad the computation and then return it in an environment context
    fun<A> bind(t: Environment.() -> A) = t(this)
    //fun<T> evaluate(init: Environment.() -> T)  = init(this)
    //private val databaseService = DatabaseModule
}