package com.hyperspacegamepanel.helper;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    // mail sender setting
    public static final String EMAIL_FROM = ""; // the mail you want to send from
    public static final String EMAIL_APP_PASSWORD = ""; // app password (gmail)

    // tickets setting
    public static final int TICKET_MESSAGE_SIZE = 1000; // change to your needs.
    public static final String TICKET_MAXIMUM_MESSAGE_ERROR = "Maximum 1000 characters are allowed";

    // assigning game ids (statically)
    public static final Map<String, Integer> GAME_IDS = new HashMap<>();

    static {
        GAME_IDS.put("cs", 1);
        GAME_IDS.put("csgo", 2);
        GAME_IDS.put("samp", 3);
        GAME_IDS.put("mc", 4);
    }
    
}
