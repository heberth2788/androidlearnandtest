package com.bbs.learnandtest.coroutines

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlin.system.measureTimeMillis

/***
 * Create coroutines:
 *
 * launch: return a Job (Does not carry any result value)
 * async:  return a Deferred (Represent a promise to provide result later), Deffered.await()
 * runBlocking: is also a coroutine builder that bridges the non-coroutine world of a
 *              regular 'function' and the code with coroutines inside of runBlocking { ... }
 */

class MyCoroutine {
    suspend fun testingCoroutineDefault() {
        val timeMillis = measureTimeMillis {
            val oneValue = doSomethingUsefulOne()
            val twoValue = doSomethingUsefulTwo()
            println("Sum = ${oneValue + twoValue}")
        }
        println("Time millis = $timeMillis")
    }

    @OptIn(DelicateCoroutinesApi::class)
    suspend fun testingCoroutineWithAsyncAndAwait() {
        val timeMillis = measureTimeMillis {
            val oneValue = GlobalScope.async { doSomethingUsefulOne() }
            val twoValue = GlobalScope.async { doSomethingUsefulTwo() }
            println("Sum = ${oneValue.await() + twoValue.await()}")
        }
        println("Time millis = $timeMillis")
    }

    suspend fun doSomethingUsefulOne(): Int {
        delay(1000L)
        return 10
    }

    suspend fun doSomethingUsefulTwo(): Int {
        delay(1000L)
        return 20
    }
}