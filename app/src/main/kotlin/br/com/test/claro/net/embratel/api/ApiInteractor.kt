package br.com.test.claro.net.embratel.api

import br.com.test.claro.net.embratel.model.Shots
import rx.Observable

interface ApiInteractor {
    fun getShots(page: String): Observable<List<Shots>>
}