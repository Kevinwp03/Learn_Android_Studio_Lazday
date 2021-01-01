package com.lazday.learnandroidstudiolazday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent = findViewById(R.id.buttonNext1)
        btnIntent.setOnClickListener(this)

    }

    override fun onClick(v: View) { // cek tanda tanya "?"
        when(v.id){
            R.id.buttonNext1 -> run {
                val intentBiasa = Intent(this@HomeActivity, RadioButtonActivity::class.java)
                startActivity(intentBiasa)
            }
        }
    }
}