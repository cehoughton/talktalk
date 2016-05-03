package com.epicodus.talktalk.models;

import org.parceler.Parcel;

@Parcel
public class Message {
    String content;

    public Message() {}

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
