package br.com.luisfernandez.dogclient.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.luisfernandez.dogclient.R
import br.com.luisfernandez.dogclient.ui.dogimages.DogImageGridFragment

class DogImageGridActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_list)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, DogImageGridFragment.newInstance())
                    .commitNow()
        }
    }
}
