package br.com.luisfernandez.dogclient.model

import br.com.luisfernandez.dogclient.pojo.Dog
import br.com.luisfernandez.dogclient.pojo.DogImage
import io.reactivex.Observable


interface DogModel {
    fun loadDogList(): Observable<List<Dog>>
    fun loadDogImageList(dogBreed: String): Observable<List<DogImage>>
}