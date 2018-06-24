package br.com.luisfernandez.dogclient.model

import br.com.luisfernandez.dogclient.pojo.Dog

class DogModelImpl : DogModel {
    override fun loadDogList(): List<Dog> {
        var list = ArrayList<Dog>()

        list.add(Dog("affenpinscher"))
        list.add(Dog("african"))
        list.add(Dog("airedale"))
        list.add(Dog("akita"))

        return list
    }
}