package com.example.springboot_websocket.utils;

import com.example.springboot_websocket.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

public class SendMessage{

    public static SimpMessagingTemplate messagingTemplate;

    /**
     * 客户端只要订阅了/topic/all主题，调用这个方法即可
     */
    public static void sendMessage() {
        Message message = new Message("系统消息", "我是广播消息");
        messagingTemplate.convertAndSend("/topic/all", message);
    }

    /**
     * 发送信息给指定用户
     */
    public static void sendMessageToUser(String user){
        System.out.println("来自服务端的消息,推送给" + user + "用户");
        messagingTemplate.convertAndSendToUser(user+"","/appoint",new Message("单向消息","只有你能收到此消息"));
    }

}