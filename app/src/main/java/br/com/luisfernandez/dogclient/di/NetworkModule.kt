package br.com.luisfernandez.dogclient.di

import br.com.luisfernandez.dogclient.BuildConfig
import br.com.luisfernandez.dogclient.http.DogWebServiceApi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
open class NetworkModule
{
    companion object
    {
        private const val TIME_OUT: Long = 15L
    }

    @Provides
    @Singleton
    @Named("HTTP_URL")
    fun provideHost(): String = "https://dog.ceo/api/"

    @Provides
    @Singleton
    fun provideScalarsConverter(): ScalarsConverterFactory = ScalarsConverterFactory.create()

    @Provides
    @Singleton
    fun provideHttpLogging(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttp(
            httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        return OkHttpClient
                .Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .followRedirects(true)
                .followSslRedirects(true)
                .retryOnConnectionFailure(true)
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
            @Named("HTTP_URL") baseUrl: String,
            okHttpClient: OkHttpClient,
            scalarsConverterFactory: ScalarsConverterFactory
    ): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(scalarsConverterFactory)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): DogWebServiceApi = retrofit.create(DogWebServiceApi::class.java)
}