package com.caretech.servicefocus.core

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import co.zsmb.materialdrawerkt.draweritems.badge
import co.zsmb.materialdrawerkt.draweritems.badgeable.PrimaryDrawerItemKt
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.IIcon


fun PrimaryDrawerItemKt.badge(text: String) {
    badge(text) {
        cornersDp = 10
        color = 0xFF0099FF
        textColor = 0xFFFFFFFF
        colorPressed = 0xFFCC99FF
    }
}


fun Context.icon(icon : IIcon , color : Int = Color.WHITE , size : Int = 14 ) : Drawable {
    return IconicsDrawable(this)
            .icon(icon)
            .sizeDp(size)
            .color(color)

}

fun Context.color(@ColorInt id : Int) : Int = ContextCompat.getColor(this,id)
