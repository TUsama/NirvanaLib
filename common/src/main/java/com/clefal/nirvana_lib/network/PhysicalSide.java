package com.clefal.nirvana_lib.network;

public enum PhysicalSide {
    CLIENT,SERVER;

    public boolean isClient() {
        return this == CLIENT;
    }
}
