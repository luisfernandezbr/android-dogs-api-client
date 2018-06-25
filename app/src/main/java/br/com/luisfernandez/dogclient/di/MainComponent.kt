package br.com.luisfernandez.dogclient.di

import br.com.luisfernandez.dogclient.ui.dogimages.DogImageGridFragment
import br.com.luisfernandez.dogclient.ui.doglist.DogListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class,
        ModelModule::class
))
interface MainComponent {
    fun inject(dogImageGridFragment: DogImageGridFragment)
    fun inject(dogListFragment: DogListFragment)
}

