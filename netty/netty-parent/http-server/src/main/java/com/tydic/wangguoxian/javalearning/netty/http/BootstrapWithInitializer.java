package com.tydic.wangguoxian.javalearning.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;

import java.net.InetSocketAddress;

/**
 * 代码清单 8-6 引导和使用 ChannelInitializer
 *
 * @author <a href="mailto:norman.maurer@gmail.com">Norman Maurer</a>
 */
public class BootstrapWithInitializer {

    public static void main(String[] args) throws InterruptedException {
        new BootstrapWithInitializer().bootstrap();
    }

    /**
     * 代码清单 8-6 引导和使用 ChannelInitializer
     * */
    public void bootstrap() throws InterruptedException {
        //创建 ServerBootstrap 以创建和绑定新的 Channel
        ServerBootstrap bootstrap = new ServerBootstrap();
        //设置 EventLoopGroup，其将提供用以处理 Channel 事件的 EventLoop
        bootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
            //指定 Channel 的实现
            .channel(NioServerSocketChannel.class)
            //注册一个 ChannelInitializerImpl 的实例来设置 ChannelPipeline
            .childHandler(new HttpPipelineInitializer(false));
        //绑定到地址
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
        future.sync();
    }


}
