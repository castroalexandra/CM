package com.example.cm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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

    class LineViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        val titulo = itemView.findViewById<TextView>(R.id.notaTitulo)
        val conteudo = itemView.findViewById<TextView>(R.id.notaConteudo)
        val data = itemView.findViewById<TextView>(R.id.notaData)
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

    }
    internal fun setNotas (notas: List<Nota>){
        this.notas = notas
        notifyDataSetChanged()
    }

    override fun getItemCount() = notas.size

    }