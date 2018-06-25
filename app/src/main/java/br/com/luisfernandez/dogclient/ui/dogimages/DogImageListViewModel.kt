package br.com.luisfernandez.dogclient.ui.dogimages

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import br.com.luisfernandez.dogclient.model.DogModel
import br.com.luisfernandez.dogclient.pojo.DogImage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DogImageListViewModel: ViewModel() {

    private val dogImageListLiveData: MutableLiveData<List<DogImage>> = MutableLiveData()
    lateinit var dogModel: DogModel

    fun inject(dogModel: DogModel) {
        this.dogModel = dogModel
    }

    fun loadDogImageList(dogBreed: String): LiveData<List<DogImage>> {
        dogModel
                .loadDogImageList(dogBreed)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ list ->
                    dogImageListLiveData.value = list
                }, { throwable -> Log.e("", "Error retrieving List: ", throwable) })


        return dogImageListLiveData
    }
}