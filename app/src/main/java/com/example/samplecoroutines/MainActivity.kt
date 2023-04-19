package com.example.samplecoroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val thread = Thread {
            // currentThread()は、スレッドの名前、優先度、スレッドグループを
            // 返す文字列表現に変換されたThreadインスタンスを返す
            println("${Thread.currentThread()} has run.")
        }
        thread.start()

        // コルーチンを使用
        val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
        GlobalScope.launch {
            println("${Thread.currentThread()} has started")
            for (i in states) {
                println("${Thread.currentThread()} - $i")
                delay(5000)
            }
        }
    }
}