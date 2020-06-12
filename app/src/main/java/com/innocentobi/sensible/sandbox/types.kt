package com.innocentobi.sensible.sandbox

import com.innocentobi.sensible.syntax.Environment


typealias Action<T> = Environment.() -> T
