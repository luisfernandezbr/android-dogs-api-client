package br.com.luisfernandez.dogclient.di

import br.com.luisfernandez.dogclient.http.DogWebServiceApi
import br.com.luisfernandez.dogclient.model.DogModel
import br.com.luisfernandez.dogclient.model.DogModelImpl
import dagger.Module
import dagger.Provides

@Module
class ModelModule {

    @Provides
    fun providesDogModel(
            dogWebServiceApi: DogWebServiceApi
    ): DogModel = DogModelImpl(dogWebServiceApi)
}