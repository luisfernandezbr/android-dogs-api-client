package br.com.luisfernandez.dogclient.model

import android.util.Log
import br.com.luisfernandez.dogclient.http.DogWebServiceApi
import br.com.luisfernandez.dogclient.pojo.Dog
import br.com.luisfernandez.dogclient.pojo.DogImage
import com.google.gson.Gson
import io.reactivex.Observable
import javax.inject.Inject
import com.google.gson.reflect.TypeToken
import java.util.stream.Collectors.mapping
import com.google.gson.JsonElement
import org.json.JSONObject


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
            var jsonObject = JSONObject(it)
            val jsonArray = jsonObject.getJSONArray("message")

            var list = ArrayList<Dog>(jsonArray.length())

            for (i in 0..(jsonArray.length() - 1)) {
                val item = jsonArray.getString(i)
                list.add(Dog(item))
            }

            list
        }
    }

    override fun loadDogImageList(dogBreed: String): Observable<List<DogImage>> {
        return dogWebServiceApi.listDogImages(dogBreed).map {
            val jsonObject = JSONObject(it)
            val jsonArray = jsonObject.getJSONArray("message")

            val list = ArrayList<DogImage>(jsonArray.length())

            for (i in 0..(jsonArray.length() - 1)) {
                val item = jsonArray.getString(i)
                list.add(DogImage(item))
            }

            list
        }
    }
}