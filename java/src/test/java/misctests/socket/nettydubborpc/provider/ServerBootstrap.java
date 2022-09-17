package misctests.socket.nettydubborpc.provider;

import misctests.socket.nettydubborpc.netty.NettyServer;

public class ServerBootstrap {
    public static void main(String[] args) {
        NettyServer.startserver("127.0.0.1", 7000);
    }
}
