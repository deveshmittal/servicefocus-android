package com.caretech.servicefocus.adapter

import com.caretech.servicefocus.R
import com.caretech.servicefocus.databinding.HeaderItemBinding
import com.xwray.groupie.databinding.BindableItem

class HeaderItem(val title: String) : BindableItem<HeaderItemBinding>() {
    override fun getLayout(): Int = R.layout.header_item
    override fun bind(p0: HeaderItemBinding, p1: Int) {
        p0.title = title
    }
}