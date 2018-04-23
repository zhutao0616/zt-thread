package com.lfp.zt.thread.vola;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Project: zt-thread
 * Title:
 * Description:
 * Date: 2018-4-10
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 1.0
 */
public class TargetTest {

    @Test
    public void testNull(){
        Target target = new Target();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        while (true) {
            target.init();
            Thread t1 = new Thread(() -> {
                target.t_one();
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            Thread t2 = new Thread(() -> {
                target.t_two();
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            target.print();
        }
    }

}
