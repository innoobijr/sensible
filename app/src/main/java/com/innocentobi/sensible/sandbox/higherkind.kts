import com.innocentobi.sensible.sandbox.ForOption
import com.innocentobi.sensible.sandbox.Kind

/**
 *  In this case, Function is an abstract class with a type parameter
 *  It also includes a companion object. Think like Option, List, etc
 *  extend the Functor interface
 */
/**
interface ForFunctor {

}

interface TestFunctor<T> {

    companion object {
        operator fun<T> invoke(t: T) = object : TestFunctor<T>{}
    }
}



interface Kin<F, A> where F: TestFunctor<A> {
    operator fun<A> invoke(a: A) = TestFunctor.invoke(a)
}




//interface FunctorT {

 //   operator fun<A> invoke(a :A) = object : Functor<A>{}
//}


interface Functor<T> {

    fun <T, B> map(t: T, f : (T) -> B) : Functor<B>
    //abstract operator fun invoke(t:T) : Functor<T>

    //companion object {
    //    operator fun<T> invoke(t:T) = object : Functor<T>(){}
    //}

}

/**interface FunctorT {

    companion object {
        operator fun<T> invoke(t:T) = Functor<T>()
    }
}**/


/**
 *  So something like:
 *  Kind<Option, F> == Option<A>..
 *  okay so them there is a type alias such that:
 *      Kind<F, A> == F[A]
 */


interface G {

    val g: Kind<ForOption, String>
}

/**
 * Alias
 */

/**
 *  Okay so the actually thing with the parameter, need an object (factory to constrcut it)
 */

//open class Option<A> : Functor<A>
data class Some<A>(val value: A) : OptionT<A>
data class None<A>(val value: A) : OptionT<A>



interface For{
    operator fun<T> invoke(t: T)

}

interface ToOption {

    fun fix() = {}

    companion object {
        fun<T> invoke(t: T) = ForOption(t)
    }
}

interface Functor<T> {

    fun <T, B> map(t: T, f: (T) -> B): Functor<B>
    //abstract operator fun invoke(t:T) : Functor<T>

    //companion object {
    //    operator fun<T> invoke(t:T) = object : Functor<T>(){}
    //}

}




interface ForOption : For {

    companion object {
        operator fun <A> invoke(v: A): OptionT<A> =
            when(v == null){
                true -> None(v)
                else -> Some(v)
            }
    }

}

val h = ForOption

open class OptionT<A> : Functor<A> {

    override fun <T, B> map(t: T, f: (T) -> B): Functor<B>  =
        ForOption.invoke(f(t))
}

interface OptionFunctor<A> : Functor<A> {

    override fun <T, B> map(t: T, f: (T) -> B): Functor<B>  =
        ForOption.invoke(f(t))
}


interface Kind<F , A> where F : For {

    operator fun invoke(f: F, a: A) = f.invoke(a)
}

abstract class Kind2<F, A> where F : Functor<A>

//F is not the Option, but an Option constructor

interface FunctorT {

    companion object {

    }
}
val j : Kind2<>

//class Some<T> : Option<T>
//class None<T> : Option<T>


typealias Option<A> = Kind<ForOption, A>




val k  = Some(1)

interface K<A> {
    val j : Kind<For, A>
}

class GG : K<String> {
    override val j: Kind<F, String> = Some(1)
}

//-----------
// Could bne an applicative, bifunction
// F is anything that can create a A
// or anything that can raise an A, into the context of F
interface Applicative<T> {
    fun<A> T.lift(a: A) : T
}


interface TFunctor<T> {


    operator fun <T> invoke(t: T)


    //fun <T, B> map(t: T, f : (T) -> B) : Functor<B>
    //abstract operator fun invoke(t:T) : Functor<T>

    //companion object {
    //    operator fun<T> invoke(t:T) = object : Functor<T>(){}
    //}

}

object For {

    operator fun<T, A> invoke(t: T, a: A) where T : To<A>{

    }
}

interface To<A> {
    operator fun<A> invoke(a : A) : To<A>
}

interface OptionA<A> : To<A> {
    override fun <A> invoke(a: A): OptionA<A>  =
        when (a == null){
            true -> None<A>()
            else -> Some<A>()
        }

}

class Some<A>() : OptionA<A>()
data class None<A>(val v : A) : OptionA<A>()

// Need to use advance language features to define this
interface Kind3<F: For, A> {

    fun fix() = F
}

interface A<T>
class B<T>(v: String) : A<T>
class C<T> : A<T>

val j : A<String> = B("sdfscs")**/


val j = Kind<ForOption<String>, String>(ForOption(), "asdad")
val h = j.fix()
println(j.invoke("kk"))