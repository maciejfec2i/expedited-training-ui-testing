package com.saucedemo.utils;

import java.time.Duration;

public class Timeouts {

    private static int SPECIFIED_GLOBAL_ELEMENT_VISIBLE_TIMEOUT;
    private static int SPECIFIED_GLOBAL_ELEMENT_CLICKABLE_TIMEOUT;

    static {
        SPECIFIED_GLOBAL_ELEMENT_VISIBLE_TIMEOUT = 0;
        SPECIFIED_GLOBAL_ELEMENT_CLICKABLE_TIMEOUT = 0;
    }

    public static void set() {
        SPECIFIED_GLOBAL_ELEMENT_VISIBLE_TIMEOUT = Integer.parseInt(Environment.getSystemEnvironmentVariables().getProperty("wait.until.target.visible.timeout"));
        SPECIFIED_GLOBAL_ELEMENT_CLICKABLE_TIMEOUT = Integer.parseInt(Environment.getSystemEnvironmentVariables().getProperty("wait.until.target.clickable.timeout"));
    }

    public static Duration specifiedElementVisibleTimeout() {
        return Duration.ofSeconds(SPECIFIED_GLOBAL_ELEMENT_VISIBLE_TIMEOUT);
    }

    public static Duration specifiedElementClickableTimeout() {
        return Duration.ofSeconds(SPECIFIED_GLOBAL_ELEMENT_CLICKABLE_TIMEOUT);
    }
}
