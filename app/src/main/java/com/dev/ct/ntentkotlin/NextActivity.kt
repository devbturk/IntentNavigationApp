package com.dev.ct.ntentkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dev.ct.ntentkotlin.databinding.ActivityMainBinding
import com.dev.ct.ntentkotlin.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // MainActivity'den gelen intent'i alıyoruz.
        // Yani: Diğer ekrandan (MainActivity) bize gönderilen verileri taşıyan nesne.
        val intentFromMain = intent
        // intent içinden "name" anahtarıyla gönderilen veriyi alıyoruz.
        // Bu veri, bir String (yazı) türündedir.
        // Örneğin: MainActivity'den "Ali" gönderildiyse burada name = "Ali" olur.
        val name = intentFromMain.getStringExtra("name")
        // Alınan ismi, ekranda bir TextView içine yazıyoruz.
        // nameTextView adındaki TextView’in içine "Naneme: Ali" gibi bir yazı yazılır.
        binding.nameTextView.text = "Naneme: ${name}"


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}