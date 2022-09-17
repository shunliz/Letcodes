package misctests.socket.nettydubborpc.customer;


import misctests.socket.nettydubborpc.netty.NettyClient;
import misctests.socket.nettydubborpc.publicinterface.HelloService;


public class ClientBootstrap {
    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) {
        NettyClient customer = new NettyClient();
        HelloService service = (HelloService) customer.getBean(HelloService.class, providerName);
        String res = service.hello("你好dubbo。。。");
        System.out.println("调用结果 res="+res);

    }
}
