package com.chusdevil.listaelementosdeapis

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ElementosViewHolder (itemView : View): ViewHolder(itemView) {

    private val title = itemView.findViewById<TextView>(R.id.titulo)
    private val content = itemView.findViewById<TextView>(R.id.contenido)

    fun datosElementoLista (titulo : String, contenido:String){
        title.text = titulo
        content.text = contenido
    }
}