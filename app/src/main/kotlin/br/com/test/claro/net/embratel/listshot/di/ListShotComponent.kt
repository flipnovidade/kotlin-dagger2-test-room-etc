package listshot.di

import br.com.test.claro.net.embratel.di.module.common.AppComponent
import br.com.test.claro.net.embratel.di.scope.FragmentScope
import dagger.Component
import listshot.ListShotFragment

@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ListShotModule::class))
interface ListShotComponent {
    fun inject(fragment: ListShotFragment)
}
