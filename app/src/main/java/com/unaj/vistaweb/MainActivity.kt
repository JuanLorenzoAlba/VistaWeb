package com.unaj.vistaweb

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), UrlFragment.MiListener {

    private lateinit var vistaFragment: VistaFragment
    private lateinit var urlFragment: UrlFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        urlFragment = supportFragmentManager.findFragmentById(R.id.urlFragmentContainer) as UrlFragment
        vistaFragment = supportFragmentManager.findFragmentById(R.id.vistaFragmentContainer) as VistaFragment
    }

    override fun onButtonClick(url: String) {
        urlFragment.mostrarSpinner()
        vistaFragment.verPagina(url, onFinish = {
            urlFragment.ocultarSpinner()
        })
    }
}


