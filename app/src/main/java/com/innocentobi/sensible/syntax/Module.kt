package com.innocentobi.sensible.syntax

import kotlin.coroutines.Continuation

interface Module<T> { // typeclass
    val service : T
}


