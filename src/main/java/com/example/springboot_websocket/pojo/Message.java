package com.example.springboot_websocket.pojo;

import lombok.Data;

/**
 * @author zhuzhaoman
 * @date 2020/6/14 0014 22:17
 * @description 描述
 */
@Data
public class Message {

    /**
     * 名称
     */
    private String name;

    /**
     * 内容
     */
    private String content;

    public Message(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
