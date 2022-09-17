package bigdata.testZK2;

import com.sun.javafx.sg.prism.web.NGWebView;
import org.apache.zookeeper.*;
import org.redisson.cluster.ClusterNodeInfo;

import java.io.IOException;
import java.util.List;

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

        String path1 = zooKeeper.create("/qiurunze-master/server", "slave".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("success create znode:"+ path1);
        List<String> children = zooKeeper.getChildren("/qiurunze-master", null);
        boolean flag = false;

        for(String s: children){
            byte[] data = zooKeeper.getData("/qiurunze-master/"+s,false, null);
            String res = new String(data);
            if(res.equals("master")){
                flag = true;
            }
        }

        if(!flag){
            zooKeeper.setData(path1,"master".getBytes(),-1);
        }

        zooKeeper.getChildren("/qiurunze-master", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                handleEvent(event);
            }

            private void handleEvent(WatchedEvent event) {
                if(event.getType().equals(Event.EventType.NodeChildrenChanged)){
                    try {
                        System.out.println("Get Node children changed event.");
                        List<String> children2 = zooKeeper.getChildren("/qiurunze-master",null);
                        boolean flag = false;
                        Integer min = 0;
                        String minstr = null;
                        for(String s: children2){
                            byte[] data = zooKeeper.getData("/qiurunze-master/"+s,false, null);
                            String res = new String(data);
                            Integer idx = Integer.parseInt(res.substring(6,res.length()));
                            if(idx < min){
                                min = idx;
                                minstr = res.substring(6,res.length());
                            }
                            if(res.equals("master")){
                                flag = true;
                            }
                        }

                        if(!flag){
                            zooKeeper.setData("/qiurunze-master/server"+minstr,"master".getBytes(),-1);
                            System.out.println("Set "+minstr+" as the master");
                        }
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        while(true){
            System.out.println("worker:"+Thread.currentThread().getId()+" is working..........");
            Thread.sleep(2000);
        }

    }
}
