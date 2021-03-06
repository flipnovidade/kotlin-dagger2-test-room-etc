package listshot.di

import dagger.Module
import dagger.Provides
import listshot.ListShotView
import listshot.ListShotViewPresenter
import listshot.ListShotViewPresenterImpl

@Module
class ListShotModule(private val view: ListShotView){

    @Provides
    fun provideListShotView(): ListShotView {
        return this.view
    }

    @Provides
    fun provideListShotPresenter(view: ListShotView): ListShotViewPresenter {
        return ListShotViewPresenterImpl(view)
    }

}