package com.lfp.zt.thread.daemon;

/**
 * Project: zt-thread
 * Title:
 * Description:
 * Date: 2018-4-23
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 1.0
 */
public class DaemonThread {

    public static void main(String[] args){
        //创建守护线程一直执行，每1秒循环一次
        Thread thread = new Thread(()->{
            try {
                while (true) {
                    System.out.println("DaemonThread work!");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("DaemonThread finally!");
            }
        },"DaemonThread");
        thread.setDaemon(true);
        thread.start();
        //主线程等待10秒后结束，同步也关闭了守护线程
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
