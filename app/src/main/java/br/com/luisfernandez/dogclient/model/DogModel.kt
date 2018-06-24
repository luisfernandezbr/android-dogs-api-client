package br.com.luisfernandez.dogclient.model

import br.com.luisfernandez.dogclient.pojo.Dog

interface DogModel {
    fun loadDogList(): List<Dog>
}