package jp.cordea.notificationaggregator

import android.content.Context
import android.preference.PreferenceManager

class PreferencesProvider(context: Context) {
    companion object {
        private const val ACCOUNT_NAME = "account_name"
    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var accountName: String? = null
        get() = preferences.getString(ACCOUNT_NAME, null)
        set(value) {
            preferences.edit().putString(ACCOUNT_NAME, field).apply()
        }
}
