package com.muse.demo;

import java.util.Random;

public class Utils {

    public static String generateEmail() {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        String domain = ".dev@musepay.io";
        Random random = new Random();

        // 生成随机用户名（长度6-12）
        int length = random.nextInt(7) + 6;
        StringBuilder username = new StringBuilder();
        for (int i = 0; i < length; i++) {
            username.append(chars.charAt(random.nextInt(chars.length())));
        }
        return username.toString() + domain;
    }

}
