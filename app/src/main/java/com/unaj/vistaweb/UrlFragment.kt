package com.unaj.vistaweb

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.Fragment

class UrlFragment : Fragment() {

    private lateinit var editTextUrl: EditText
    private lateinit var buttonLoad: Button
    private lateinit var progressBar: ProgressBar
    private var listener: MiListener? = null

    interface MiListener {
        fun onButtonClick(url: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MiListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement MiListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_url, container, false)

        editTextUrl = view.findViewById(R.id.editTextUrl)
        buttonLoad = view.findViewById(R.id.buttonLoad)
        progressBar = view.findViewById(R.id.progressBarSmall)

        buttonLoad.setOnClickListener {
            val url = editTextUrl.text.toString()
            listener?.onButtonClick(url)
        }

        return view
    }

    fun mostrarSpinner() {
        progressBar.visibility = View.VISIBLE
        buttonLoad.isEnabled = false // desactiva el botón
    }

    fun ocultarSpinner() {
        progressBar.visibility = View.GONE
        buttonLoad.isEnabled = true // vuelve a activarlo
    }
}