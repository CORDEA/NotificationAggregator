package jp.cordea.notificationaggregator

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import kotlinx.coroutines.experimental.launch
import java.io.IOException

class NotificationService : NotificationListenerService() {
    private val provider get() = PreferencesProvider(applicationContext)

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        val notification = sbn?.notification ?: return
        val title = notification.extras.getCharSequence(Notification.EXTRA_TITLE)?.toString() ?: ""
        val text = notification.extras.getCharSequence(Notification.EXTRA_TEXT)?.toString() ?: ""
        val subText = notification.extras
                .getCharSequence(Notification.EXTRA_SUB_TEXT)?.toString() ?: ""
        val big = notification.extras.getCharSequence(Notification.EXTRA_BIG_TEXT)?.toString() ?: ""
        val from = provider.from ?: return
        val to = provider.to ?: return
        launch {
            try {
                MailgunApiClient.postMessage(
                        from,
                        to,
                        title,
                        text
                ).execute()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}
