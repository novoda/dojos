package com.example.android.automessagingcodelab;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

public class MessagingService extends IntentService {
    private static final String TAG = MessagingService.class.getSimpleName();

    /**
     * The Action that indicates that a new message notification
     * should be sent by this Service.
     */
    public static final String SEND_MESSAGE_ACTION = "com.example.anroid.automessagingcodelab.ACTION_SEND_MESSAGE";
    public static final String READ_ACTION = "com.example.android.automessagingcodelab.ACTION_MESSAGE_READ";
    public static final String REPLY_ACTION = "com.example.android.automessagingcodelab.ACTION_MESSAGE_REPLY";
    public static final String CONVERSATION_ID = "conversation_id";
    public static final String EXTRA_VOICE_REPLY = "extra_voice_reply";

    public MessagingService() {
        super(MessagingService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (SEND_MESSAGE_ACTION.equals(intent.getAction())) {
            sendNotificationForConversation(
                    Conversations.CONVERSATION_ID,
                    Conversations.SENDER_NAME,
                    Conversations.getUnreadMessage(),
                    System.currentTimeMillis()
            );
        }
    }

    private void sendNotificationForConversation(int conversationId, String sender, String message, long timestamp) {
        // A pending Intent for messages being read
        PendingIntent readPendingIntent = PendingIntent.getBroadcast(
                getApplicationContext(),
                conversationId,
                getMessageReadIntent(conversationId),
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        /// Add the code to create the UnreadConversation

        /// End create UnreadConversation

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext())
                .setSmallIcon(R.drawable.notification_icon)
                .setLargeIcon(
                        BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.android_contact)
                )
                .setContentText(message)
                .setWhen(timestamp)
                .setContentTitle(sender)
                .setContentIntent(readPendingIntent)
                /// Extend the notification with CarExtender.

                /// End extend the notification with CarExtender
                ;

        Log.d(TAG, "Sending notification " + conversationId + " conversation: " + message);

        NotificationManagerCompat.from(this)
                .notify(conversationId, builder.build());
    }

    // Creates an intent that will be triggered when a message is read.
    private Intent getMessageReadIntent(int id) {
        return new Intent().setAction(READ_ACTION)
                .putExtra(CONVERSATION_ID, id);
    }

    // Creates an Intent that will be triggered when a voice reply is received.
    private Intent getMessageReplyIntent(int conversationId) {
        return new Intent().setAction(REPLY_ACTION)
                .putExtra(CONVERSATION_ID, conversationId);
    }
}
