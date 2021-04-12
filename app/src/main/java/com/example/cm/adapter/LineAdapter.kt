package com.example.cm.adapter

import android.R.attr.fragment
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cm.EditaNotaFragment
import com.example.cm.NotasActivity
import com.example.cm.R
import com.example.cm.entities.Nota


/*import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cm.R
import com.example.cm.dataclasses.Nota


class LineAdapter(var list: ArrayList<Nota>):RecyclerView.Adapter<LineViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineViewHolder {
       val itemView = LayoutInflater
           .from(parent.context)
           .inflate(R.layout.recycler_line, parent, false  );
        return LineViewHolder(itemView)

    }

    override fun getItemCount(): Int {
       return list.size
    }

    fun setNotas(notas: ArrayList<Nota>) {
        list = notas
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: LineViewHolder, position: Int) {
       val currentNota = list[position]

        holder.titulo.text = currentNota.titulo
        holder.conteudo.text = currentNota.conteudo
        holder.data.text = currentNota.data
    }
}
class LineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val titulo = itemView.findViewById<TextView>(R.id.notaTitulo)
    val conteudo = itemView.findViewById<TextView>(R.id.notaConteudo)
    val data = itemView.findViewById<TextView>(R.id.notaData)
}

*/

class LineAdapter internal constructor(
        context: Context
) : RecyclerView.Adapter<LineAdapter.LineViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var notas = emptyList<Nota>()
    val ctx = context as NotasActivity

    class LineViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        val titulo = itemView.findViewById<TextView>(R.id.notaTitulo)
        val conteudo = itemView.findViewById<TextView>(R.id.notaConteudo)
        val data = itemView.findViewById<TextView>(R.id.notaData)
        val apagar = itemView.findViewById<ImageButton>(R.id.apagarBtn)
        val editar = itemView.findViewById<ImageButton>(R.id.editarBtn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineViewHolder {
        val itemView = inflater.inflate(R.layout.recycler_line, parent, false)

        return LineViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LineViewHolder, position: Int) {
        val current = notas[position]

        holder.titulo.text = current.titulo
        holder.conteudo.text = current.conteudo
        holder.data.text = current.data

        holder.apagar.setOnClickListener {
            ctx.deleteNota(current.id!!)
        }

        holder.editar.setOnClickListener {
            val testString : String = "example only"
            var bundle = Bundle()
            bundle.putInt("id", current.id!!)
            bundle.putString("titulo", current.titulo)
            bundle.putString("conteudo", current.conteudo)
            Log.e("id", (current.id).toString())
            Log.e("titulo", current.titulo)
            Log.e("conteudo", current.conteudo)
            var frag = EditaNotaFragment()
            frag.arguments = bundle
            ctx.changeFragment(frag)
        }

    }
    internal fun setNotas (notas: List<Nota>){
        this.notas = notas
        notifyDataSetChanged()
    }

    override fun getItemCount() = notas.size

    }