package nettydubborpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import nettydubborpc.provider.HelloServiceImpl;


public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("msg="+msg);
        if(msg.toString().startsWith("HelloService#hello#")){
            String res = new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf('#')+1));
            ctx.writeAndFlush(res);
        }
    }
}
