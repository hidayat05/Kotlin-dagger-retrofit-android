package id.maskipli.kotlindagger.common.di

import dagger.Component
import id.maskipli.kotlindagger.MainActivity
import id.maskipli.kotlindagger.common.di.modules.AndroidModule
import javax.inject.Singleton

/**
 * @author nurhidayat
 * @since 07/02/18.
 */

@Singleton
@Component(modules = arrayOf(AndroidModule::class))
interface ApplicationComponent {


    fun inject(activity: MainActivity)
}