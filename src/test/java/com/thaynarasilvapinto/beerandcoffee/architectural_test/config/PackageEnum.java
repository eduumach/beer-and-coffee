package com.thaynarasilvapinto.beerandcoffee.architectural_test.config;

public enum PackageEnum {
    CONTROLLER("com.thaynarasilvapinto.beerandcoffee.controller");

    private final String description;

    PackageEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
