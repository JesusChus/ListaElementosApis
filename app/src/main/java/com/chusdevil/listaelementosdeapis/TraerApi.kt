package com.chusdevil.listaelementosdeapis

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TraerApi {

    @GET("posts")
    fun traerDatos() : Call<List<DatosApi>>

}