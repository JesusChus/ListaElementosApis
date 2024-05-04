package com.chusdevil.listaelementosdeapis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

class ListaAdapter (val lista: MutableList<ElementoLista>) : Adapter<ElementosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementosViewHolder {
        val elementoDeXml = LayoutInflater.from(parent.context).inflate(R.layout.elemento_de_lista,parent,false)
        val elemento = ElementosViewHolder(elementoDeXml)
        return elemento
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ElementosViewHolder, position: Int) {
        val datos : ElementoLista = lista[position]
        holder.datosElementoLista(datos.nombre, datos.descripcion)
    }
}