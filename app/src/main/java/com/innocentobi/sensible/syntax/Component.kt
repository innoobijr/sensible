package com.innocentobi.sensible.syntax

import io.reactivex.subjects.PublishSubject


abstract class Component<T, A> {

    private var source : PublishSubject<T>
    var sink : PublishSubject<A>
}
