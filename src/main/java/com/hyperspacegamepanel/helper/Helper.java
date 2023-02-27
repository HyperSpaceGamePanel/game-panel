package com.hyperspacegamepanel.helper;

import java.net.InetAddress;
import java.util.Random;

public class Helper {

    // here are those methods that use globally without any dependencies whether via thymeleaf or server-side.

    public boolean isMachineOnline(String ipAddress) {
        boolean isReachable = false;
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            isReachable = address.isReachable(5000); // Time out in milliseconds (5 seconds here)

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isReachable;
    }

    public static String randomPasswordGenerator() {

        String allCharacters = "abcdefghijklmnopqrstuvwxyz,ABCDEFGHIJKLMNOPQRSTUVWXYZ,0123456789,!@#$%^&*()_-+={}[]\\|:;\'<>,.?/";

        Random random = new Random();
        StringBuilder passwordBuilder = new StringBuilder();

        for(int i = 0; i < 20; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            passwordBuilder.append(allCharacters.charAt(randomIndex));
        }

        return passwordBuilder.toString();
    }
    
}
