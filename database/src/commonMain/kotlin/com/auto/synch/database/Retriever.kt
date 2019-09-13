package com.auto.synch.database

interface Retriever<T> {
    fun registerForReceiver(callback: (T) -> Unit)
    fun update(value: T)
}

abstract class BaseRetriever<T> : Retriever<T> {

    private val callbacks = mutableListOf<(T) -> Unit>()

    override fun registerForReceiver(callback: (T) -> Unit) {
        callbacks.add(callback)
    }

    override fun update(value: T) {
        callbacks.forEach {
            it(value)
        }
    }
}