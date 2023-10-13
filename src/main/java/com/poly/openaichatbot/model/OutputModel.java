package com.poly.openaichatbot.model;

public class OutputModel {

    String userOutput;

    public String getUserOutput() {
        return userOutput;
    }

    public void setUserOutput(String userOutput) {
        this.userOutput = userOutput;
    }

    @Override
    public String toString() {
        return "OutputModel{" +
                "userOutput='" + userOutput + '\'' +
                '}';
    }
}
