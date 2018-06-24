package br.com.luisfernandez.dogclient.ui.doglist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.luisfernandez.dogclient.R
import br.com.luisfernandez.dogclient.pojo.Dog

class DogListFragment : Fragment() {

    companion object {
        fun newInstance() = DogListFragment()
    }

    private lateinit var viewModel: DogListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_dog_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DogListViewModel::class.java)

        val observer = Observer<List<Dog>> { list: List<Dog>? ->

            list?.let {
                for (dog in it) {
                    Log.d("", "DogName: ${dog.name}")
                }
            }
        }

        viewModel.loadDogList().observe(this, observer)
    }

}
