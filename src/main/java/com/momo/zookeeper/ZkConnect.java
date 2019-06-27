package com.momo.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * zk简单连接
 */
public class ZkConnect implements Watcher {
    final static Logger log = LoggerFactory.getLogger(ZkConnect.class);
    private static final String zkServerPath = "114.115.215.115:2181";
    public static final String zkClusterPath = "192.168.1.101:2181,192.168.1.102:2181,192.168.1.103:2181";
    private static final Integer tiomeOut=5000;
    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper=new ZooKeeper(zkServerPath,tiomeOut,new ZkConnect());
        log.info("客户端开始连接zookeeper服务器...");
        log.info("连接状态：{}", zooKeeper.getState());
        Thread.sleep(2000);
        log.info("连接状态：{}", zooKeeper.getState());
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        log.info("接受到watch通知：{}", watchedEvent);
    }
}
