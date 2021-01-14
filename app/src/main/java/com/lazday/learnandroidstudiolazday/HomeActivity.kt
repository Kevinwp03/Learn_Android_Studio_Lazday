package com.lazday.learnandroidstudiolazday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class HomeActivity : AppCompatActivity(), View.OnClickListener {


    private val pref by lazy { PrefHelper (this) }

    private lateinit var btnIntent: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent = findViewById(R.id.buttonNext1)
        btnIntent.setOnClickListener(this)

        // Get data untuk menyimpan theme, dari setting Activity.
        when (pref.getBoolean("pref_is_dark_mode")){
            true -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            false -> {AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)}
        }

    }
// berpindah activity

    override fun onClick(v: View) { // cek tanda tanya "?"
        when(v.id){
            R.id.buttonNext1 -> run {
                val intentBiasa = Intent(this@HomeActivity, RadioButtonActivity::class.java)
                startActivity(intentBiasa)
            }
        }
    }

    // untuk Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // aksi terhadap menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {       // untuk menggunakan menunya
        when(item.itemId) {
            R.id.action_setting -> {
                startActivity(Intent(this, SettingActivity::class.java))
            }
        }

        return when (item.itemId) {
            R.id.action_setting -> {
                Toast.makeText(applicationContext, "Pengaturan", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_about -> {
                Toast.makeText(applicationContext, "Tentang Aplikasi", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_chart -> {
                Toast.makeText(applicationContext, "Keranjang", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}
