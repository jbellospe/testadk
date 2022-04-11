package com.example.testsdk

import android.nfc.Tag
import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun netWorkFunc1(): String {
    delay(3000L)
    return "Hola mundo 1";
}

suspend fun netWorkFunc2(): String {
    delay(3000L)
    return "Hola mundo 2";
}

fun createAsyncFunction(TAG:String) {
    GlobalScope.launch(Dispatchers.IO) {
        val time = measureTimeMillis {
            val answer1 = async { netWorkFunc1() }
            val answer2 = async { netWorkFunc2() }
            Log.d(TAG,"Answer1 is ${answer1.await()}")
            Log.d(TAG,"Answer2 is ${answer2.await()}")
        }
        Log.d(TAG,"Request took $time ms")
    }
}