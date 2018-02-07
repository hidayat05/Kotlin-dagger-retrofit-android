package id.maskipli.kotlindagger.utils

import android.support.v7.app.AppCompatActivity
import id.maskipli.kotlindagger.App
import id.maskipli.kotlindagger.common.di.ApplicationComponent

/**
 * @author nurhidayat
 * @since 07/02/18.
 */


fun AppCompatActivity.component(): ApplicationComponent
        = (application as App).component