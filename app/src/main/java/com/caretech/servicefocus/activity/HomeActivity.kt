package com.caretech.servicefocus.activity

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.divider
import com.caretech.servicefocus.R
import com.caretech.servicefocus.adapter.HeaderItem
import com.caretech.servicefocus.core.BaseActivity
import com.caretech.servicefocus.core.badge
import com.caretech.servicefocus.databinding.ActivityHomeBinding
import com.mcxiaoke.koi.ext.startActivity
import com.mikepenz.actionitembadge.library.ActionItemBadgeAdder
import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.mikepenz.materialdrawer.Drawer
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : BaseActivity() {

    lateinit var result: Drawer
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setSupportActionBar(toolBar)

        val adapter = recyclerAdapter()
        homeRv.layoutManager = LinearLayoutManager(this)
        homeRv.adapter = adapter

        adapter.add(HeaderItem("Approvals"))

        result = drawer {
            rootView = mainContent
            toolbar = toolBar
            displayBelowStatusBar = false
            actionBarDrawerToggleAnimated = true
            closeOnClick = true


            primaryItem(name = "Tickets") { iicon = GoogleMaterial.Icon.gmd_code }
            primaryItem(name = "Approvals") {
                iicon = GoogleMaterial.Icon.gmd_thumbs_up_down
                badge("10")
            }
            primaryItem(name = "Vaction") { iicon = GoogleMaterial.Icon.gmd_beach_access }
            primaryItem(name = "On-Call") { iicon = GoogleMaterial.Icon.gmd_local_phone }
            primaryItem(name = "Notes") { iicon = GoogleMaterial.Icon.gmd_note }
            primaryItem(name = "Watch List") { iicon = GoogleMaterial.Icon.gmd_hourglass_empty }
            primaryItem(name = "Change Management") { iicon = GoogleMaterial.Icon.gmd_settings_applications }
            primaryItem(name = "Vendor") { iicon = GoogleMaterial.Icon.gmd_group_work }
            primaryItem(name = "Calendar") {
                iicon = GoogleMaterial.Icon.gmd_perm_contact_calendar
                identifier = 398L
            }
            divider()
            primaryItem(name = "Guides") { iicon = GoogleMaterial.Icon.gmd_help }
            primaryItem(name = "My Account") {
                iicon = GoogleMaterial.Icon.gmd_account_circle
                identifier = 399L
            }
            primaryItem(name = "Application Settings") {
                iicon = GoogleMaterial.Icon.gmd_settings
                identifier = 400L
            }
            primaryItem(name = "About") { iicon = GoogleMaterial.Icon.gmd_store }
            primaryItem(name = "Logout") { iicon = GoogleMaterial.Icon.gmd_exit_to_app }

            onItemClick { view, position, drawerItem ->
                when (drawerItem.identifier) {
                    400L -> {
                        result.closeDrawer()
                        startActivity<AccountSettingsActivity>()
                    }
                    399L -> {
                        result.closeDrawer()
                        startActivity<MyAccountActivity>()
                    }
                    398L -> {
                        result.closeDrawer()
                        startActivity<CalendarActivity>()
                    }
                }
                true
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)

        ActionItemBadgeAdder()
                .act(this@HomeActivity)
                .menu(menu)
                .title("Notification")
                .itemDetails(0, 1, 1)
                .showAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
                .add(GoogleMaterial.Icon.gmd_notifications, Color.WHITE, 1)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        if (result.isDrawerOpen) {
            result.closeDrawer()
        } else {
            super.onBackPressed()
        }
    }

}
