package com.unaj.vistaweb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), UrlFragment.MiListener {

    private lateinit var vistaFragment: VistaFragment
    private lateinit var urlFragment: UrlFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

