package com.innocentobi.sensible.sandbox

interface To<A> {
    public operator fun<A> invoke(a : A) : To<A>
}

interface OptionK<T> : To<T>{

    override fun <A> invoke(a: A): To<A>  = Companion.invoke(a)

    companion object {
        operator fun <T> invoke(a: T): OptionK<T>  =
            when (a == null){
                true -> None<T>()
                else -> Some<T>(a)
            }
    }
}

class Some<T>(value: T) : OptionK<T>
class None<T> : OptionK<T>
