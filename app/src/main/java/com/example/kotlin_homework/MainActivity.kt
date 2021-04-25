package com.example.kotlin_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception
import java.time.Month
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.FutureTask

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.buttonResult)
        button.setOnClickListener{
            val textView = findViewById<TextView>(R.id.textView)
            val callable: Callable<Int> = getDataFromCalable(editText)
            val futureTask: FutureTask<Int> = FutureTask(callable)
            Thread(futureTask).start()
            try{
                textView.text = futureTask.get().toString()
            } catch (e: ExecutionException){
                e.printStackTrace()
            } catch (e: InterruptedException){
                e.printStackTrace()
            }
        }
    }

    private fun getDataFromCalable(editText: EditText?): Callable<Int> {
        return Callable {
            var sum = 0
            if (editText != null) {
                for (i in 2..editText.text.toString().toInt()){
                    sum +=1
                }
            }
            return@Callable sum
        }

    }
}

    fun initMonth(month: Int=3){
        when(month){
            1-> print("Зима")
            2-> print("Зима")
            3-> print("Весна")
            4-> print("Весна")
            5-> print("Весна")
            6-> print("Лето")
            7-> print("Лето")
            8-> print("Лето")
            9-> print("Осень")
            10-> print("Осень")
            11-> print("Осень")
            12-> print("Зима")
            else-> print("Не знаю")
        }
    }

