package nettydubborpc.provider;

import nettydubborpc.publicinterface.HelloService;

public class HelloServiceImpl  implements HelloService {
    @Override
    public String hello(String s) {
        System.out.println("收到客户端消息:"+s);
        return "你好我已收到你的消息:"+s;
    }
}
