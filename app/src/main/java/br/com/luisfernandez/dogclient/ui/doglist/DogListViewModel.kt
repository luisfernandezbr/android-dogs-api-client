package br.com.luisfernandez.dogclient.ui.doglist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.luisfernandez.dogclient.model.DogModelImpl
import br.com.luisfernandez.dogclient.pojo.Dog

class DogListViewModel : ViewModel() {

    val dogListLiveData: MutableLiveData<List<Dog>> = MutableLiveData()

    fun loadDogList(): LiveData<List<Dog>> {
        dogListLiveData.value = DogModelImpl().loadDogList()
        return dogListLiveData
    }
}
