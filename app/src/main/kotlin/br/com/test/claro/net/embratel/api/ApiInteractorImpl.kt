package br.com.test.claro.net.embratel.api

import br.com.test.claro.net.embratel.model.Shots
import br.com.test.claro.net.embratel.uitls.AppConstant
import retrofit2.Retrofit
import rx.Observable
import javax.inject.Inject

class ApiInteractorImpl():  ApiInteractor {

    @Inject lateinit var api: ApiModule

    override fun getShots(page: String): Observable<List<Shots>> {
        //return api.provideService(adapter).getShots(AppConstant.Dribbble.Token, page, AppConstant.Dribbble.PER_PAGE)
        return api.service().getShots(AppConstant.Dribbble.Token, page, AppConstant.Dribbble.PER_PAGE)
    }
}