package br.com.luisfernandez.dogclient.model

import br.com.luisfernandez.dogclient.pojo.Dog
import br.com.luisfernandez.dogclient.pojo.DogImage

interface DogModel {
    fun loadDogList(): List<Dog>
    fun loadDogImageList(): List<DogImage>
}