package com.unaj.vistaweb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), UrlFragment.MiListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Fragmentos solo se agregan si no hay estado previo
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.urlFragmentContainer, UrlFragment())
                .replace(R.id.vistaFragmentContainer, VistaFragment())
                .commit()
        }
    }

    override fun onButtonClick(url: String) {
        val vistaFragment = supportFragmentManager
            .findFragmentById(R.id.vistaFragmentContainer) as? VistaFragment
        vistaFragment?.verPagina(url)
    }
}

