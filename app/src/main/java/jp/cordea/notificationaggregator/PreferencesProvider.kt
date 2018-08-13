package jp.cordea.notificationaggregator

import android.content.Context
import android.preference.PreferenceManager

class PreferencesProvider(context: Context) {
    companion object {
        private const val TO = "to"
        private const val FROM = "from"
    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var to: String?
        get() = preferences.getString(TO, null)
        set(value) {
            preferences.edit().putString(TO, value).apply()
        }

    var from: String?
        get() = preferences.getString(FROM, null)
        set(value) {
            preferences.edit().putString(FROM, value).apply()
        }
}
