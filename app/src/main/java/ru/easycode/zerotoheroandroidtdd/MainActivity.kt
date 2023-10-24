package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private companion object {
        const val VISIBILITY = "visibility"
    }

    private lateinit var textView: TextView
    private lateinit var button: Button
    private var textViewIsVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.hideButton)

        if (savedInstanceState != null) {
            textView.visibility = if(textViewIsVisible) View.VISIBLE else View.INVISIBLE
        }

        button.setOnClickListener {
            textViewIsVisible = false
            textView.visibility = View.INVISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putBoolean(VISIBILITY, textViewIsVisible)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        if (savedInstanceState != null) {
            textViewIsVisible = savedInstanceState.getBoolean(VISIBILITY, false)
        }
    }


}