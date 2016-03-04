package com.example.android.automessagingcodelab;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A simple class that denotes unread conversations and messages. In a real world application,
 * this would be replaced by a content provider that actually gets the unread messages to be
 * shown to the user.
 */
public class Conversations {

    /**
     * Set of strings used as messages by the sample.
     */
    private static final String[] MESSAGES = new String[]{
            "Are you at home?",
            "Can you give me a call?",
            "Hey yt?",
            "Don't forget to get some milk on your way back home",
            "Is that project done?",
            "Did you finish the Messaging app yet?"
    };

    /**
     * Senders of all the messages.
     */
    public static final String SENDER_NAME = "John Doe";

    /**
     * A static conversation Id for all our messages.
     */
    public static final int CONVERSATION_ID = 13;

    private Conversations() {
        // helper class
    }

    public static String getUnreadMessage() {
        return MESSAGES[ThreadLocalRandom.current().nextInt(0, MESSAGES.length)];
    }
}
