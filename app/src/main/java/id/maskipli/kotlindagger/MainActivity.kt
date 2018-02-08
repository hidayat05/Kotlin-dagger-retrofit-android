package id.maskipli.kotlindagger

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import id.maskipli.kotlindagger.networking.RestClient
import id.maskipli.kotlindagger.utils.Constant
import id.maskipli.kotlindagger.utils.component
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject lateinit var mContext : Context

    private val parentJob =  Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component().inject(this)

        Log.e("Log for dagger", "context from $mContext")
    }


    override fun onResume() {
        super.onResume()
        getAllUser()
    }


    private fun getAllUser() {
        async (parentJob + UI){
            val task = async(parentJob + CommonPool){
                RestClient.apiUrl.getGalaxy(Constant.API_KEY).execute()
            }

            val result = task.await()


        }.invokeOnCompletion {
            alertWithOkButton("Caught an exception inside invoke on completion callback")
            it?.printStackTrace()
        }
    }


    private fun alertWithOkButton(message: String){
        alert(message) {
            okButton {  }
        }.show()
    }
}
