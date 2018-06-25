package br.com.luisfernandez.dogclient.model

import android.util.Log
import br.com.luisfernandez.dogclient.http.DogWebServiceApi
import br.com.luisfernandez.dogclient.pojo.Dog
import br.com.luisfernandez.dogclient.pojo.DogImage
import io.reactivex.Observable
import javax.inject.Inject

class DogModelImpl @Inject constructor(
        val dogWebServiceApi: DogWebServiceApi
) :  DogModel {

    override fun loadDogList(): Observable<List<Dog>> {
        val list = ArrayList<Dog>()

        list.add(Dog("affenpinscher"))
        list.add(Dog("african"))
        list.add(Dog("airedale"))
        list.add(Dog("akita"))

        return dogWebServiceApi.listDogs().map {
            ArrayList<Dog>()
        }
    }

    override fun loadDogImageList(): Observable<List<DogImage>> {
        val list = ArrayList<DogImage>()

        list.add(DogImage("https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg"))
        list.add(DogImage("https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg"))
        list.add(DogImage("https://images.dog.ceo/breeds/hound-afghan/n02088094_1023.jpg"))
        list.add(DogImage("https://images.dog.ceo/breeds/hound-afghan/n02088094_10263.jpg"))

        return dogWebServiceApi.listDogImages("").map {
            ArrayList<DogImage>()
        }
    }
}