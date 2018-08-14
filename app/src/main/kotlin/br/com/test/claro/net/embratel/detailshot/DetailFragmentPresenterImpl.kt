package detailshot


import br.com.test.claro.net.embratel.model.Shots
import java.io.Serializable

class DetailFragmentPresenterImpl(private val view: DetailFragmentView) : DetailFragmentPresenter {
    private var shot: Shots? = null


    override fun onCreate() {
        shot?.let {
            view.configureView(it)
        }
    }

    override fun onReceiveSerializable(serializable: Serializable?) {
        if(serializable is Shots){
            shot = serializable
        }
    }

    override fun onDestroy() {
    }
}