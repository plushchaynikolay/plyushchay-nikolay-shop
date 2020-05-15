package com.example.nikolay_plyushchay_shop.utils

import android.text.Editable
import android.text.TextWatcher

class AfterTextChangedWatcher(
    private val afterTextChangedAction: (Editable?) -> Unit
) : TextWatcher {
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun afterTextChanged(s: Editable?) = afterTextChangedAction(s)
}