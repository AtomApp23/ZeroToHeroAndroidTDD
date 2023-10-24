package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.getString

class MainActivity : AppCompatActivity() {
    private companion object {
        const val SAVE_TEXT = "text"
    }

    private lateinit var textView: TextView
    private var savedText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedText = textFromResources()

        textView = findViewById(R.id.titleTextView)
        val button = findViewById<Button>(R.id.changeButton)

        if (savedInstanceState != null) {
            setTextToTextView()
        }

        button.setOnClickListener {
            setTextToTextView()
        }

    }

    private fun setTextToTextView() {
        textView.text = savedText
    }

    private fun textFromResources(): String {
        return getString(R.string.android_developer)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(SAVE_TEXT, savedText)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        if (savedInstanceState != null) {
            savedText = savedInstanceState.getString(SAVE_TEXT, "")
        }
    }
}