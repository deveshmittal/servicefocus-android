package com.caretech.servicefocus.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.caretech.servicefocus.R
import com.caretech.servicefocus.core.BaseActivity
import com.caretech.servicefocus.databinding.ActivityMyAccountBinding
import kotlinx.android.synthetic.main.activity_my_account.*

class MyAccountActivity : BaseActivity() {

    lateinit var binding: ActivityMyAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_account)

        setSupportActionBar(toolBar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.title = "My Accounts"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                android.R.id.home -> onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
