package listshot

import rx.Subscription

class ListShotViewPresenterImpl(private val view: ListShotView): ListShotViewPresenter {
    private var subscription: Subscription? = null

    override fun onCreate(nPage: Int) {
//        subscription = apiInteractor.getShots(nPage.toString())
//                .compose(RxComposer.ioThread())
//                .doOnSubscribe(view::showProgress)
//                .doOnTerminate(view::dismissProgress)
//                .subscribe({
//                    view.setView(it)
//                }, { throwable ->
//                    Timber.e(throwable, "Error call updateBroadBandEligibility")
//                    view.onError(throwable)
//                })

        view.setView(null, "Felippeeeeeeeee")
    }

    override fun onDestroy() {
        if (!subscription?.isUnsubscribed!!) {
            subscription?.unsubscribe()
        }
    }


}