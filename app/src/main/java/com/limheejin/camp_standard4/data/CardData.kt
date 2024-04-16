package com.limheejin.camp_standard4.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.text.DecimalFormat

@Parcelize
data class CardData(
    val name: String,
    val cardNumber: String,
    val expDate: String,
    val price: Float,
    val type : Int
) : Parcelable


fun priceDecimal(price: Float): String = DecimalFormat("###,###,###.##").format(price)
