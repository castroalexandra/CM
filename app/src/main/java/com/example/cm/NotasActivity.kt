package com.example.cm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cm.adapter.LineAdapter
import com.example.cm.entities.Nota
import com.example.cm.viewModel.NotaViewModel

class NotasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)

        changeFragment(ListaNotasFragment())
    }

    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.contentFragment, fragment)
            .commit()
    }

    /*fun setObserver(): ArrayList<com.example.cm.dataclasses.Nota> {
        var content = ArrayList<com.example.cm.dataclasses.Nota>()
        val notasViewModel: NotaViewModel = ViewModelProvider(this).get(NotaViewModel::class.java)
        notasViewModel.allNotas.observe(this, Observer { notas ->
            notas?.let{
                for(nota in it){
                    var notaCurrent = com.example.cm.dataclasses.Nota(nota.titulo, nota.conteudo, "08-04-2021")
                    Log.e("a ler", nota.conteudo)
                    content.add(notaCurrent)
                }
            }
        })

        return content
    }*/

    fun setObserver(): NotaViewModel {
        val notasViewModel: NotaViewModel = ViewModelProvider(this).get(NotaViewModel::class.java)

        return notasViewModel
    }

    fun insertNota(nota: Nota){
        val notasViewModel: NotaViewModel = ViewModelProvider(this).get(NotaViewModel::class.java)
        notasViewModel.insert(nota)
    }
}