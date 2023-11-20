package com.example.hotel.extensions

import com.google.android.material.textview.MaterialTextView

fun bindPeculiarities(listTv: List<MaterialTextView>, listStrings: List<String>) {
    listStrings.forEachIndexed { index, s ->
        if (index < listTv.size) {
            listTv[index].text = s
        }
    }
}
