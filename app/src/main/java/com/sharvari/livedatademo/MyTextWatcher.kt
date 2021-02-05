package com.sharvari.livedatademo

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast

class MyTextWatcher(context: Context, viewModel: TextViewModel) : TextWatcher{

    private val context : Context = context;
    private val viewModel = viewModel

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        Toast.makeText(context, p0, Toast.LENGTH_SHORT).show()
        viewModel.updatedText(p0.toString());
    }

    override fun afterTextChanged(p0: Editable?) {

    }

}