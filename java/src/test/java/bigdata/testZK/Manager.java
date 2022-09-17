package bigdata.testZK;

import org.apache.zookeeper.*;

import java.io.IOException;

public class Manager {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("123.57.162.179:2181",5000,new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("有监听事件进来了，事件信息 " + watchedEvent);
            }
        });

        //由于new 完Zookeeper对象就会创建，而不会在意是否连接上了，所以这里阻塞以下，直至连接成功（网上很多例子用的是CountDownLatch方式）
        while (zooKeeper.getState() != ZooKeeper.States.CONNECTED){
            System.out.println("连接中...");
            Thread.sleep(300);
        }

        /**
         *   创建节点参数
         *   节点路径 相当于文件目录一样，zk根节点是 / ,注意创建节点时，一定要以 / 开头
         *   节点数据 节点想要保存的数据，（如果附带服务ip端口信息，zk就当作了注册中心，客户端可拉取服务信息进行访问）
         *   节点权限 zk的acl权限，这里设置的是所有人可读，具体权限前面放的地址有解释
         *   节点类型（永久的、临时的、顺序性的，根据枚举名自行翻译。不了解节点类型，请先根据前面连接熟悉一下，或自行搜索了解一下）
         */

        String path1 = zooKeeper.create("/myservers", "manager:port".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("success create znode:"+ path1);

        zooKeeper.close();

    }
}
