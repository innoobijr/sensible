package com.innocentobi.sensible.sandbox

import com.innocentobi.sensible.instance.envs.ProdEnvironment

object Env {

    fun add(x:Int, y: Int): Int = x + y
    fun subtract(x: Int, y:Int) = x - y

    fun<T> execute(init: Env.() -> T) = init(this)

}


// What are the benefits of using a typealias vs an interface or class
typealias Work<T> = Env.() -> T


data class Job<T>(private val init: Env.() -> T){
    //operator fun<T> invoke() = init(Env)
    fun run() = init(Env)

    //Idk if this is effective or necessary.
    // the comp isnt called?
    companion object {
        operator fun<T> invoke(init: Env.() -> T) = init(Env)
    }

}


// A job is just turning a computation into a data structure
// Benefits are composition
// Asynchrony and parallelism
data class Job2<T>(private val init: Env.() -> T){
    //operator fun<T> invoke() = init(Env)
    fun run() = init(Env)

    //Idk if this is effective or necessary.
    // the comp isnt called?

}

Job2{}



// This way the Job can be encapsualted as a data structued and pattern matche agains, right
// rather than just a type alias
// A Job is unevaluated. And is only envaluvated wnen and environment is passed in
val h = Job{

}
h.run()



val task : Work<Int> = { add(4, 5)}
val task2 : Action<Int> = { add(4, 5)}

fun<T, K, A> T.bind(t: Work<A>) where T : Env = t(this)

//Effectful sequential execution
//Now the trick is to abstract over error handling
/*Environment.evaluate{
    val i = bind(task2)
    val j = i + 9
    j
}*/

/* This essentially mean that Environment. It is very similar to the Reader Monad
Categorically it is a Kleisli
An action is literally an action! The benefit of making it a Type with
 */

val production  = ProdEnvironment

production {
    val i = task2() //Super benefit of the way this is written. :) just calling parenthesis
    // allows us to bind by calling the task
    val j  = i + 8
    j
}

val g = task(Env)


/**
 *
 * Try to generate a higher-kind type using kotlin's syntax
 * Blog about how the language deal with the construction
 * Talk about Kotlin higher-kind and the KEEP82 proposal
 * Talk about how this is different in SCala or Haskell
 **/