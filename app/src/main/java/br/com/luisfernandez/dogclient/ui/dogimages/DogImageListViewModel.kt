package br.com.luisfernandez.dogclient.ui.dogimages

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.luisfernandez.dogclient.model.DogModel
import br.com.luisfernandez.dogclient.pojo.DogImage

class DogImageListViewModel: ViewModel() {

    private val dogImageListLiveData: MutableLiveData<List<DogImage>> = MutableLiveData()
    lateinit var dogModel: DogModel

    fun inject(dogModel: DogModel) {
        this.dogModel = dogModel
    }

    fun loadDogImageList(): LiveData<List<DogImage>> {
        //dogImageListLiveData.value = dogModel.loadDogImageList()
        return dogImageListLiveData
    }
}