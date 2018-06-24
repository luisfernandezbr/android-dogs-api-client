package br.com.luisfernandez.dogclient.model

import br.com.luisfernandez.dogclient.pojo.Dog
import br.com.luisfernandez.dogclient.pojo.DogImage

class DogModelImpl : DogModel {
    override fun loadDogList(): List<Dog> {
        val list = ArrayList<Dog>()

        list.add(Dog("affenpinscher"))
        list.add(Dog("african"))
        list.add(Dog("airedale"))
        list.add(Dog("akita"))

        return list
    }

    override fun loadDogImageList(): List<DogImage> {
        val list = ArrayList<DogImage>()

        list.add(DogImage("https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg"))
        list.add(DogImage("https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg"))
        list.add(DogImage("https://images.dog.ceo/breeds/hound-afghan/n02088094_1023.jpg"))
        list.add(DogImage("https://images.dog.ceo/breeds/hound-afghan/n02088094_10263.jpg"))

        return list
    }
}