package com.caretech.servicefocus.core

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.mcxiaoke.koi.ext.getApp
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

open class BaseActivity : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    fun application(): Application = this.getApp()
    fun recyclerAdapter(): GroupAdapter<ViewHolder> = adapter()
}