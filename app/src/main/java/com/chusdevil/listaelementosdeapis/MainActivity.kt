package com.chusdevil.listaelementosdeapis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MainActivity : AppCompatActivity() {

    private val listaMutable = mutableListOf<ElementoLista>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ****Creamos la lista y la inicializamos****
        val lista = findViewById<RecyclerView>(R.id.rvLista)
        val adapter = ListaAdapter(listaMutable)
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adapter



        // **** Traemos la lista de la API ****
        val retrofit = inicializarRetrofit()
        val laApi = retrofit.create(TraerApi::class.java)
        laApi.traerDatos().enqueue(object : Callback<List<DatosApi>>{
            override fun onResponse(p0: Call<List<DatosApi>>, p1: Response<List<DatosApi>>) {

                val cuerpo = p1.body()!!
                cuerpo.forEach {
                    listaMutable.add(ElementoLista(it.title,it.body))
                }

                adapter.notifyDataSetChanged()
            }

            override fun onFailure(p0: Call<List<DatosApi>>, p1: Throwable) {

            }


        })

    }
    // **** Inicializamos Retrofit ****
    fun inicializarRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}