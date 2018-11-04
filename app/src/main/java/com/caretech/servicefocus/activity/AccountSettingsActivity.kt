package com.caretech.servicefocus.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.caretech.servicefocus.R
import com.caretech.servicefocus.core.BaseActivity
import com.caretech.servicefocus.databinding.ActivityAccountSettingsBinding
import kotlinx.android.synthetic.main.activity_account_settings.*

class AccountSettingsActivity : BaseActivity() {

    lateinit var binding: ActivityAccountSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_account_settings)


        setSupportActionBar(toolBar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.title = "Application Settings"
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
