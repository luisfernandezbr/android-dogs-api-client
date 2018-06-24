package br.com.luisfernandez.dogclient.ui.dogimages

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.luisfernandez.dogclient.R
import br.com.luisfernandez.dogclient.pojo.DogImage

class DogImageGridFragment : Fragment() {

    companion object {
        fun newInstance() = DogImageGridFragment()
    }

    private lateinit var viewModel: DogImageListViewModel
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_dog_list, container, false)

        val layoutManager = GridLayoutManager(context, 3)
        recyclerView = view.findViewById(R.id.recyclerView)

        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = DogImageGridAdapter()

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DogImageListViewModel::class.java)

        val observer = Observer<List<DogImage>> { list: List<DogImage>? ->
            list?.let {
                showContent(it)
            }
        }

        viewModel.loadDogImageList().observe(this, observer)
    }

    fun showContent(dogList: List<DogImage>) {
        dogList.let {
            (recyclerView.adapter as DogImageGridAdapter).add(it)
        }
    }
}
