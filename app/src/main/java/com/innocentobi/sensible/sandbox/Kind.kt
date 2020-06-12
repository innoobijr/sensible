package com.innocentobi.sensible.sandbox


interface For<T, A> where T : To<A>{

    operator fun invoke(a: A) : T

}

class ForOption<A> : For<To<A>, A> {
    override fun invoke(a: A): OptionK<A> = OptionK.invoke(a)
    fun fix()  = this as OptionK<A>

}

typealias ForT<A> = For<To<A>, A>

interface Kind<F, A> where F : ForT<A>{

    fun invoke(f: F, a: A) = f.invoke(a)

    companion object {
        operator fun<F, A> invoke(f: F, a: A) where F : For<To<A>, A> = object : Kind<F, A>{}.invoke(f, a) as F
    }
}
