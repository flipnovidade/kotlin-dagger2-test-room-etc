package detailshot

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.test.claro.net.embratel.AppDelegate
import br.com.test.claro.net.embratel.model.Shots
import detailshot.di.DetailModule
import listshot.ListShotFragment
import javax.inject.Inject
import br.com.test.claro.net.embratel.R
import detailshot.di.DaggerDetailCompoment

class DetailFragment: Fragment(), DetailFragmentView {

    @Inject
    lateinit var presenter: DetailFragmentPresenter

    companion object {

        private const val CUSTON_SHOT = "CUSTON_SHOT"

        @JvmStatic
        fun newInstance(shot: Shots): ListShotFragment {
            val bundle = Bundle()
            bundle.putSerializable(CUSTON_SHOT, shot)
            val fragment = ListShotFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail_shot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerDetailCompoment.builder()
                .appComponent(AppDelegate.component)
                .detailModule(DetailModule(this))
                .build().inject(this)

        presenter.onReceiveSerializable(arguments?.getSerializable(CUSTON_SHOT))
        presenter.onCreate()
    }

    override fun configureView(shot: Shots) {
    }

    override fun onDestroy() {
        if (::presenter.isInitialized) {
            presenter.onDestroy()
        }
        super.onDestroy()
    }

}