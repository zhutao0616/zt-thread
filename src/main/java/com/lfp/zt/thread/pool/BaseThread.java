package com.lfp.zt.thread.pool;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Project: zt-thread
 * Title:
 * Description:
 * Date: 2018-4-20
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 1.0
 */
public class BaseThread {

    public static void main(String[] args){
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] infos = bean.dumpAllThreads(false,false);
        for (ThreadInfo info : infos) {
            System.out.println("["+info.getThreadId()+"] " + info.getThreadName());
        }
    }

}
