package listshot

import br.com.test.claro.net.embratel.model.Shots

interface ListShotView {
    fun onError(throwable: Throwable)
    fun setView(listShots: List<Shots>?, texto: String)
    fun showProgress()
    fun dismissProgress()
}