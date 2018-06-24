package br.com.luisfernandez.dogclient.ui.dogimages

import android.support.v4.widget.ImageViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.luisfernandez.dogclient.R
import br.com.luisfernandez.dogclient.pojo.DogImage
import com.squareup.picasso.Picasso
import java.util.ArrayList

class DogImageGridAdapter: RecyclerView.Adapter<DogImageGridAdapter.DogImageGridViewHolder>() {

    private val dogImageList: ArrayList<DogImage> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DogImageGridViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_dog_image, parent, false))

    override fun getItemCount() = dogImageList.size

    override fun onBindViewHolder(holder: DogImageGridViewHolder, position: Int) {
        val dog = dogImageList[position]
        Picasso.get()
                .load(dog.imageUrl)
                .resize(50, 50)
                .into(holder.imageDog)
    }

    fun add(dogList: List<DogImage>) {
        this.dogImageList.addAll(dogList)
        this.notifyDataSetChanged()
    }

    class DogImageGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageDog = itemView.findViewById<android.support.v7.widget.AppCompatImageView>(R.id.imageDog)
    }
}