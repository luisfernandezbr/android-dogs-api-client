package br.com.luisfernandez.dogclient

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.luisfernandez.dogclient.pojo.Dog
import java.util.ArrayList

class DogListAdapter: RecyclerView.Adapter<DogListAdapter.DogListViewHolder>() {

    val dogList: ArrayList<Dog> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DogListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_dog_name, parent, false))

    override fun getItemCount() = dogList.size

    override fun onBindViewHolder(holder: DogListViewHolder, position: Int) {
        val dog = dogList[position]
        holder.textName.text = dog.name
    }

    fun add(dogList: List<Dog>) {
        this.dogList.addAll(dogList)
        this.notifyDataSetChanged()
    }

    class DogListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textName = itemView.findViewById<TextView>(R.id.textName)
    }
}