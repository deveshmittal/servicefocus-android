package com.caretech.servicefocus

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.caretech.servicefocus.activity.HomeActivity
import com.caretech.servicefocus.core.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
        }, 2000)
    }
}
