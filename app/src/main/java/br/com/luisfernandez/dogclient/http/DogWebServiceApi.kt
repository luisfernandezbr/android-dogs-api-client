package br.com.luisfernandez.dogclient.http

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface DogWebServiceApi {

    @GET("breeds/list/all")
    fun listDogs(): Observable<String>

    @GET("breed/{breedName}/images")
    fun listDogImages(@Path("breedName") breedName: String): Observable<String>
}