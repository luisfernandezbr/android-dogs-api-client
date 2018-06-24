package br.com.luisfernandez.dogclient.ui.dogimages

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.luisfernandez.dogclient.model.DogModelImpl
import br.com.luisfernandez.dogclient.pojo.DogImage

class DogImageListViewModel : ViewModel() {

    private val dogImageListLiveData: MutableLiveData<List<DogImage>> = MutableLiveData()

    fun loadDogImageList(): LiveData<List<DogImage>> {
        dogImageListLiveData.value = DogModelImpl().loadDogImageList()
        return dogImageListLiveData
    }
}
