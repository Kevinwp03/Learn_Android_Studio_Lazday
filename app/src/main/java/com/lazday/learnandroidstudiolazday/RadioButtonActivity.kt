package com.lazday.learnandroidstudiolazday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.radio_button.*

class RadioButtonActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.radio_button)

        setupListener()

        btnIntent = findViewById(R.id.buttonNextRadio)
        btnIntent.setOnClickListener(this)
    }

// radio button
    fun setupListener(){
        radioG.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            Toast.makeText(applicationContext, radio.text, Toast.LENGTH_SHORT).show()
        }
    }

// Intent
    override fun onClick(v: View) { // cek tanda tanya "?"
        when(v.id){
            R.id.buttonNextRadio -> run {
                val intentBiasa = Intent(this@RadioButtonActivity, RelativeLayoutActivity::class.java)
                startActivity(intentBiasa)
                // jika teradi masalah pada inten, ganti variable val nya, menjadi berbeda dengan sebelumnya
            }
        }
    }
}