package com.netty.rpc.server;

import com.netty.rpc.protobuf.RichManProto;
import com.netty.rpc.protobuf.RichManProto.RichMan.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.List;

public class ProtoBufServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)throws Exception{
        RichManProto.RichMan request = (RichManProto.RichMan) msg;
        System.out.println(request.getName()+ "他有" + request.getCarsCount()+ "辆车");
        List<Car> list = request.getCarsList();
        if (null != list){
            for (Car car: list) {
                System.out.println(car.getName());
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
