package com.example.cm

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cm.adapter.LineAdapter
import com.example.cm.dataclasses.Nota
import com.example.cm.viewModel.NotaViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var myList: ArrayList<Nota>
/**
 * A simple [Fragment] subclass.
 * Use the [ListaNotasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaNotasFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_lista_notas, container, false)

        val addNotaBtn = view.findViewById<FloatingActionButton>(R.id.criaNotaBtn)
        addNotaBtn.setOnClickListener(){
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.contentFragment, CriaNotaFragment())
            transaction?.commit()
        }

        val notasActivity: NotasActivity = activity as NotasActivity
        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)

        var content = ArrayList<com.example.cm.dataclasses.Nota>()
        var adapter = LineAdapter(activity as NotasActivity)
        var nvm = notasActivity.setObserver()
        nvm.allNotas.observe(this, Observer { notas ->
            notas?.let{
                adapter.setNotas(it)
            }

            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager (this.activity)
        })


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListaNotasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListaNotasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}