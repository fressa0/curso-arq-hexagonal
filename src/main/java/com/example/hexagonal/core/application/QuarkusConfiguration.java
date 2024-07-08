package com.example.hexagonal.core.application;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "quarkusconfiguration")
public class QuarkusConfiguration {

    private String name;
    private int version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
