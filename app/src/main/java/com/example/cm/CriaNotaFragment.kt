package com.example.cm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cm.entities.Nota
import com.example.cm.viewModel.NotaViewModel
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CriaNotaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CriaNotaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cria_nota, container, false)

        val notasActivity: NotasActivity = activity as NotasActivity

        val guardarNotaBtn = view.findViewById<Button>(R.id.guardarBtn)
        val titulo = view.findViewById<EditText>(R.id.titulo)
        val conteudo = view.findViewById<EditText>(R.id.conteudo)
        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        guardarNotaBtn.setOnClickListener(){
            val nota = Nota(titulo = titulo.text.toString(), conteudo = conteudo.text.toString(), data = currentDateAndTime)
            notasActivity.insertNota(nota)
            notasActivity.changeFragment(ListaNotasFragment())
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CriaNotaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CriaNotaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}