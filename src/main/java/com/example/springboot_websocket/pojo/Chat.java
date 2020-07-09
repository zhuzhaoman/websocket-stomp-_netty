package com.example.springboot_websocket.pojo;

/**
 * @author zhuzhaoman
 * @date 2020/6/14 0014 23:21
 * @description 描述
 */
public class Chat {

    private String to;
    private String from;
    private String content;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
