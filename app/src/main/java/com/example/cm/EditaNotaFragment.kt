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
class EditaNotaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var id: Int? = null
    private var titulo: String? = null
    private var conteudo: String? = null
    private var clicks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt("id")
            titulo = it.getString("titulo")
            conteudo = it.getString("conteudo")
            Log.e("id2", (id).toString())
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
        val tituloTV = view.findViewById<EditText>(R.id.titulo)
        val conteudoTV = view.findViewById<EditText>(R.id.conteudo)

        tituloTV.setText(titulo)
        conteudoTV.setText(conteudo)

        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        guardarNotaBtn.setOnClickListener(){
                notasActivity.editNota(id!!, conteudoTV.text.toString(), tituloTV.text.toString())
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