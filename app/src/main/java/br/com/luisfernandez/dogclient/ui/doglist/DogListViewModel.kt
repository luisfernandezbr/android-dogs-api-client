package br.com.luisfernandez.dogclient.ui.doglist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import br.com.luisfernandez.dogclient.model.DogModel
import br.com.luisfernandez.dogclient.pojo.Dog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DogListViewModel: ViewModel() {

    private val dogListLiveData: MutableLiveData<List<Dog>> = MutableLiveData()
    lateinit var dogModel: DogModel

    fun inject(dogModel: DogModel) {
        this.dogModel = dogModel
    }

    fun loadDogList(): LiveData<List<Dog>> {
        dogModel
                .loadDogList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ list ->
                    dogListLiveData.value = null
                }, { throwable -> Log.e("", "Error retrieving InstallmentsList: ", throwable) })



        return dogListLiveData
    }
}
