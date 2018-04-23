package com.lfp.zt.thread.interrupt;

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
public class InterruptThread {

    public static void main(String[] args){
        Thread sleepThread = new Thread(()->{
            try {
                while (true) {
                    System.out.println("SleepThread sleep!");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"SleepThread");
        sleepThread.setDaemon(true);
        sleepThread.start();

        Thread workThread = new Thread(()->{
            while (true) {
               // System.out.println("WorkThread work!");
            }
        },"WorkThread");
        workThread.setDaemon(true);
        workThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("SleepThread is interrupted: "+ sleepThread.isInterrupted());
        System.out.println("WorkThread is interrupted: "+ workThread.isInterrupted());

        sleepThread.interrupt();
        workThread.interrupt();

        System.out.println("SleepThread is interrupted: "+ sleepThread.isInterrupted());
        System.out.println("WorkThread is interrupted: "+ workThread.isInterrupted());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
