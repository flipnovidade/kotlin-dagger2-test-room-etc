package detailshot.di

import br.com.test.claro.net.embratel.di.module.common.AppComponent
import br.com.test.claro.net.embratel.di.scope.FragmentScope
import dagger.Component
import detailshot.DetailFragment

@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(DetailModule::class))
interface DetailCompoment {
    fun inject(fragment: DetailFragment)
}
