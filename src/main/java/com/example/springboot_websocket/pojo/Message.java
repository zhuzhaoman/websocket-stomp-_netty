package com.example.springboot_websocket.pojo;

/**
 * @author zhuzhaoman
 * @date 2020/6/14 0014 22:17
 * @description 描述
 */
public class Message {

    private String name;
    private String content;

    public Message(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
