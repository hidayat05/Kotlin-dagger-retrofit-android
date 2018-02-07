package id.maskipli.kotlindagger.common.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * @author nurhidayat
 * @since 07/02/18.
 */
@Module
class AndroidModule(private val application: Application){

    @Provides
    fun provideApplicationContext(): Context = application

}