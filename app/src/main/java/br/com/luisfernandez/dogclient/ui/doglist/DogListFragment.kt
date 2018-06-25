package br.com.luisfernandez.dogclient.ui.doglist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.luisfernandez.dogclient.AppApplication
import br.com.luisfernandez.dogclient.R
import br.com.luisfernandez.dogclient.pojo.Dog
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProvider
import br.com.luisfernandez.dogclient.model.DogModel


class DogListFragment : Fragment() {

    companion object {
        fun newInstance() = DogListFragment()
    }

    private lateinit var viewModel: DogListViewModel

    @Inject
    lateinit var dogModel: DogModel

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_dog_list, container, false)

        AppApplication.component.inject(this)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)

        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = DogListAdapter()

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DogListViewModel::class.java)


        viewModel.inject(dogModel)

        val observer = Observer<List<Dog>> { list: List<Dog>? ->
            list?.let {
                for (dog in it) {
                    Log.d("", "DogName: ${dog.name}")
                }
                showContent(it)
            }
        }

        viewModel.loadDogList().observe(this, observer)
    }

    fun showContent(dogList: List<Dog>) {
        dogList.let {
            (recyclerView.adapter as DogListAdapter).add(it)
        }
    }
}
