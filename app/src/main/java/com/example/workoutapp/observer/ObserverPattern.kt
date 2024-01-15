package com.example.workoutapp.observer

class Observable(
    val subscribers: MutableList<Observer> = ArrayList()
) {
    fun addObserver(observer: Observer) {
        subscribers.add(observer)
    }
    fun removeObserver(observer: Observer) {
        subscribers.remove(observer)
    }
    fun notifyObservers(event: Event) {
        subscribers.forEach {
            it.update(event)
        }
    }
}

interface Observer {
    fun update(event: Event)
}

data class Event(val content: String)

fun main() {
    val observable = Observable()
    observable.addObserver(object : Observer {
        override fun update(event: Event) {
            println("Received update")
        }
    })
    observable.addObserver(object : Observer {
        override fun update(event: Event) {
            println("Also Received update")
        }
    })

    observable.notifyObservers(Event("!!!"))
}