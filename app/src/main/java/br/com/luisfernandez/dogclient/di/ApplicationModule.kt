package br.com.luisfernandez.dogclient.di

import br.com.luisfernandez.dogclient.AppApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
open class ApplicationModule(private val appApplication: AppApplication)
{
    @Provides
    @Singleton
    fun provideApplication(): AppApplication = appApplication
}