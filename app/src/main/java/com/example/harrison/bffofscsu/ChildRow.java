package com.example.harrison.bffofscsu;

/**
 * Created by Darren on 4/9/2016.
 */
public class ChildRow {
    private int icon;
    private String text;

    public ChildRow(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
