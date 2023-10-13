package com.poly.openaichatbot.model;

import org.springframework.beans.factory.annotation.Autowired;

public class InputModel {
    String userInput;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
}
