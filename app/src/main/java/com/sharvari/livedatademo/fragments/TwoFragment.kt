package com.sharvari.livedatademo.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.sharvari.livedatademo.R
import com.sharvari.livedatademo.TextViewModel

class TwoFragment : Fragment(R.layout.fragment_two){
    private val viewModel : TextViewModel by activityViewModels()
    private lateinit var etText : EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etText = view.findViewById(R.id.etText)
        etText.setText(viewModel.text.value)

        viewModel.mutableText.observe(viewLifecycleOwner, Observer {item ->
            etText.setText(item)
        })
    }
}