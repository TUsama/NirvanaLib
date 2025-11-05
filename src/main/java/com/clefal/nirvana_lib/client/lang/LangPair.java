package com.clefal.nirvana_lib.client.lang;

public class LangPair {

    private final String key;
    private final String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public LangPair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static LangPair of(String key, String value){
        return new LangPair(key, value);
    }
}
