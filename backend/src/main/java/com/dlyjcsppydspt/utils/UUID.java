package com.dlyjcsppydspt.utils;

import java.util.concurrent.ThreadLocalRandom;

public class UUID {

    public static String randomUUID() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

    public static String fastUUID() {
        return randomUUID();
    }

    public static long nextId() {
        long timestamp = System.currentTimeMillis();
        long random = ThreadLocalRandom.current().nextLong(1000, 9999);
        return timestamp * 10000 + random % 10000;
    }
}
