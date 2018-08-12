package jp.cordea.notificationaggregator

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

class NotificationService : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        val notification = sbn?.notification ?: return
        val title = notification.extras.getCharSequence(Notification.EXTRA_TITLE)
        val text = notification.extras.getCharSequence(Notification.EXTRA_TEXT)
        val subText = notification.extras.getCharSequence(Notification.EXTRA_SUB_TEXT)
        val big = notification.extras.getCharSequence(Notification.EXTRA_BIG_TEXT)
    }
}
