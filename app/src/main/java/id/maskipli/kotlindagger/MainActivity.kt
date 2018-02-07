package id.maskipli.kotlindagger

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import id.maskipli.kotlindagger.utils.component
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component().inject(this)

        Log.e("Log for dagger", "context from $mContext")
    }
}
