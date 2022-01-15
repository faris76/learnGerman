package com.example.android.learngerman;

public class Model {
    private String english;
    private String german;

    public Model(String english, String german) {
        this.english = english;
        this.german = german;
    }

    public Model(){}

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getGerman() {
        return german;
    }

    public void setGerman(String german) {
        this.german = german;
    }
}
