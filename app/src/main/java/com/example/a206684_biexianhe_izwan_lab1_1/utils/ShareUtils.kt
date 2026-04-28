package com.example.a206684_biexianhe_izwan_lab1_1.utils

import android.content.Context
import android.content.Intent

fun shareOrder(context: Context, subject: String, summary: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }

    context.startActivity(
        Intent.createChooser(intent, "New Booking")
    )
}