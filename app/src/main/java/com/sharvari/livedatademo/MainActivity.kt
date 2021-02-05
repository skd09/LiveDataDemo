package com.sharvari.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sharvari.livedatademo.fragments.OneFragment
import com.sharvari.livedatademo.fragments.ThreeFragment
import com.sharvari.livedatademo.fragments.TwoFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : TextViewModel
    private lateinit var textWatcher : MyTextWatcher;
    private lateinit var etText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(TextViewModel::class.java)
        textWatcher = MyTextWatcher(this, viewModel)
        etText = findViewById(R.id.etText)

        findViewById<Button>(R.id.btnChange).setOnClickListener {
            viewModel.updatedText(etText.text.toString())
        }

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<OneFragment>(R.id.fragment1)
        }
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<TwoFragment>(R.id.fragment2)
        }
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<ThreeFragment>(R.id.fragment3)
        }


        viewModel.mutableText.observe(this, Observer {item ->
            etText.setText(item)
        })

    }


}