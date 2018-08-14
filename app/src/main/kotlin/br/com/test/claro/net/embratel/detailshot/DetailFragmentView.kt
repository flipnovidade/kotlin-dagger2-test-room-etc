package detailshot

import br.com.test.claro.net.embratel.model.Shots

interface DetailFragmentView {
    fun configureView(shot: Shots)
}