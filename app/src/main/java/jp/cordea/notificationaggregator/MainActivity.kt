package jp.cordea.notificationaggregator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val provider by lazy { PreferencesProvider(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            provider.from = from_text.editText!!.text.toString()
            provider.to = to_text.editText!!.text.toString()
        }
    }
}
