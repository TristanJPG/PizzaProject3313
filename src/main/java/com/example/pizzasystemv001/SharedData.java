package com.example.pizzasystemv001;

public class SharedData {
    private static SharedData instance = null;
    private String sharedText;

    private SharedData() {
        sharedText = "";
    }

    public static SharedData getInstance() {
        if (instance == null) {
            instance = new SharedData();
        }
        return instance;
    }

    public String getSharedText() {
        return sharedText;
    }

    public void setSharedText(String sharedText) {
        this.sharedText = sharedText;
    }
}
