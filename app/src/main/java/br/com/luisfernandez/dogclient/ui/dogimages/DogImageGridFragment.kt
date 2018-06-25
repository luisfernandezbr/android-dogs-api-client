package br.com.luisfernandez.dogclient.ui.dogimages

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.luisfernandez.dogclient.AppApplication
import br.com.luisfernandez.dogclient.R
import br.com.luisfernandez.dogclient.http.DogWebServiceApi
import br.com.luisfernandez.dogclient.model.DogModel
import br.com.luisfernandez.dogclient.pojo.DogImage
import br.com.luisfernandez.dogclient.ui.doglist.DogListViewModel
import javax.inject.Inject

class DogImageGridFragment : Fragment() {
    companion object {
        fun newInstance() = DogImageGridFragment()
    }

    private lateinit var viewModel: DogImageListViewModel

    @Inject
    lateinit var dogModel: DogModel

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_dog_list, container, false)

        AppApplication.component.inject(this)

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

        viewModel.inject(dogModel)

        val observer = Observer<List<DogImage>> { list: List<DogImage>? ->
            list?.let {
                showContent(it)
            }
        }

        viewModel.loadDogImageList("beagle").observe(this, observer)
    }

    fun showContent(dogList: List<DogImage>) {
        dogList.let {
            (recyclerView.adapter as DogImageGridAdapter).add(it)
        }
    }
}
