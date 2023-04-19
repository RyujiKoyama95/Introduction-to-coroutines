package com.example.samplecoroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.samplecoroutines.ui.theme.SampleCoroutinesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val thread = Thread {
            // currentThread()は、スレッドの名前、優先度、スレッドグループを
            // 返す文字列表現に変換されたThreadインスタンスを返す
            println("${Thread.currentThread()} has run.")
        }
        thread.start()

        val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
        Thread {
            println("${Thread.currentThread()} has started")
            for (i in states) {
                println("${Thread.currentThread()} - $i")
                Thread.sleep(50)
            }
        }.start()
    }
}