package com.example.springboot_websocket.client;

import com.example.springboot_websocket.utils.SendMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("客户端上线");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("========================== 客户端接收数据 ==========================");
        System.out.println("客户端接收到数据为："+msg);
        //SendMessage.sendMessage();
        SendMessage.sendMessageToUser("admin");
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
