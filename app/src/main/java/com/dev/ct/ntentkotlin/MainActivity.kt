package com.dev.ct.ntentkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ContentView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dev.ct.ntentkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    // Kullanıcının butona basmasıyla çalışan fonksiyon
    fun next(view: View  ){
        // Bir ekrandan diğerine geçmek için Intent oluşturuluyor.
        // Burada MainActivity'den NextActivity'ye geçilecek.
        val intent = Intent(this@MainActivity, NextActivity::class.java)
        // Kullanıcının EditText'e yazdığı metin alınıyor ve "name" etiketiyle intent'e ekleniyor.
        // .text ile yazılan metni alıyoruz, .toString() ile bunu yazı haline çeviriyoruz.
        intent.putExtra("name", binding.editTextText.text.toString())
        // intent'i kullanarak diğer ekrana (NextActivity) geçiyoruz.
        startActivity(intent)
    }
}