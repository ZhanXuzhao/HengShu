package com.zxz.hengshu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ClipData
import android.content.Context
import android.content.ClipboardManager
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            et_output.setText(
                heng2shu(
                    et_input.text.toString(),
                    et_space.text.toString(),
                    et_column_space.text.toString()
                )
            )
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_input.addTextChangedListener(textWatcher)
        et_space.addTextChangedListener(textWatcher)
        et_column_space.addTextChangedListener(textWatcher)
        iv_clear.setOnClickListener { et_input.setText("") }

        btn_copy.setOnClickListener {
            clipOutput()
            Toast.makeText(this, "copy success", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clipOutput() {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("", et_output.text)
        clipboard.primaryClip = clip
    }

}
