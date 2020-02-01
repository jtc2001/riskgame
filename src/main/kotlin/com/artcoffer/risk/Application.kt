package com.artcoffer.risk

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.jtsportsart")
                .mainClass(Application.javaClass)
                .start()
    }
}