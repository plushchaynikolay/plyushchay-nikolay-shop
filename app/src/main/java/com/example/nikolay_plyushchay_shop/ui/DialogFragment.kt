package com.example.nikolay_plyushchay_shop.ui

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogFragment(
    private val message: String,
    private val icon: Drawable,
    private val buttonText: String,
    private val buttonFunction: () -> Unit
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(activity)
            .setIcon(icon)
            .setMessage(message)
            .setPositiveButton(buttonText)
            { _, _ -> buttonFunction() }
            .create()
}