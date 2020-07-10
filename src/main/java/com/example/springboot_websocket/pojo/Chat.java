package com.example.springboot_websocket.pojo;

import lombok.Data;

/**
 * @author zhuzhaoman
 * @date 2020/6/14 0014 23:21
 * @description 描述
 */
@Data
public class Chat {

    /**
     * 接收者
     */
    private String to;

    /**
     * 发送者
     */
    private String from;

    /**
     * 发送内容
     */
    private String content;
}
