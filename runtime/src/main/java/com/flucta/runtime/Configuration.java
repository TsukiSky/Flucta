package com.flucta.runtime;

public class Configuration {
    public static int getCoreNumber() {
        return Runtime.getRuntime().availableProcessors();
    }
}
