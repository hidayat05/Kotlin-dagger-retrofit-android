package id.maskipli.kotlindagger

import android.app.Application
import id.maskipli.kotlindagger.common.di.ApplicationComponent
import id.maskipli.kotlindagger.common.di.DaggerApplicationComponent
import id.maskipli.kotlindagger.common.di.modules.AndroidModule

/**
 * @author nurhidayat
 * @since 07/02/18.
 */
class App : Application() {


    lateinit var component: ApplicationComponent


    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
                .androidModule(AndroidModule(this))
                .build()
    }
}