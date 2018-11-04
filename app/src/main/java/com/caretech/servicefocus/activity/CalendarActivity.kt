package com.caretech.servicefocus.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.caretech.servicefocus.R
import com.caretech.servicefocus.core.BaseActivity
import com.caretech.servicefocus.core.color
import com.caretech.servicefocus.core.icon
import com.caretech.servicefocus.databinding.ActivityCalendarBinding
import com.mikepenz.google_material_typeface_library.GoogleMaterial
import kotlinx.android.synthetic.main.activity_calendar.*
import java.util.*

class CalendarActivity : BaseActivity(), com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener {
    override fun onDateSet(view: com.wdullaer.materialdatetimepicker.date.DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        calendarView.scrollToCalendar(year , monthOfYear , dayOfMonth , true)
    }

    lateinit var binding: ActivityCalendarBinding

    fun updateDate() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calendar)

        setSupportActionBar(toolBar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.title = "My Accounts"

        //calendarView.setOnDate
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.calendar_menu, menu)
        menu!!.findItem(R.id.calendarSelect).icon = applicationContext.icon(GoogleMaterial.Icon.gmd_date_range, Color.WHITE, 24)
        menu.findItem(R.id.listEvents).icon = applicationContext.icon(GoogleMaterial.Icon.gmd_list, Color.WHITE, 24)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("ResourceAsColor")
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {

            android.R.id.home -> onBackPressed()

            R.id.calendarSelect -> {
                val now = Calendar.getInstance()
                val dpd = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(
                        this@CalendarActivity,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                )

                dpd.accentColor = applicationContext.color(R.color.colorPrimary)
                dpd.show(supportFragmentManager, "Pick Date")
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
