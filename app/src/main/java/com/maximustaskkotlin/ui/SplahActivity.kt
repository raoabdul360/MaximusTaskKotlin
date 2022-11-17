package com.maximustaskkotlin.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.maximustaskkotlin.R

class SplahActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splah)


        Handler().postDelayed({
            startActivity(Intent(this@SplahActivity, MainActivity::class.java))
            finish()
        }, 3000)
    }
}