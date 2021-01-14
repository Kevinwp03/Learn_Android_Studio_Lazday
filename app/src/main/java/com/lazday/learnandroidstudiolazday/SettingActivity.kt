package com.lazday.learnandroidstudiolazday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {
// menyimpan data
    private val pref by lazy { PrefHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        supportActionBar!!.title = "Pengaturan"

        switch_dark.setOnCheckedChangeListener { compoundButton, isChecked ->
            when (isChecked){
                true -> {
                    pref.put("pref_is_dark_mode", true)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                false -> {
                    pref.put("pref_is_dark_mode", false)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
        }
        switch_dark.isChecked = pref.getBoolean("pref_is_dark_mode")  // sebelumnya menggunakan if else, tapi redundant (mumbazir) di sederhanakan oleh ide

    }
}