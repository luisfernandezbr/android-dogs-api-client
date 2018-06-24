package br.com.luisfernandez.android_dog_api_client

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.luisfernandez.android_dog_api_client.ui.doglist.DogListFragment

class DogListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dog_list_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, DogListFragment.newInstance())
                    .commitNow()
        }
    }

}
