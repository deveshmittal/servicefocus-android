package com.caretech.servicefocus.core

import android.content.Context
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder


fun Context.adapter(): GroupAdapter<ViewHolder> {
    val ga = GroupAdapter<ViewHolder>()
    return ga
}