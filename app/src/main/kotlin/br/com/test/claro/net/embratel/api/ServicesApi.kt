package br.com.test.claro.net.embratel.api

import br.com.test.claro.net.embratel.model.Shots
import br.com.test.claro.net.embratel.uitls.AppConstant
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface ServicesApi {

    @GET("/v2/users/" + AppConstant.Dribbble.AccountAnother + "/shots/")
    abstract fun getShots(
            @Query("access_token") access_token: String,
            @Query("page") page: String,
            @Query("per_page") perPage: String
    ): Observable<List<Shots>>

}