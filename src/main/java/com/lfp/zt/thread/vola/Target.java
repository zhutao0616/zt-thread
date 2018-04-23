package com.lfp.zt.thread.vola;

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
public class Target {

    volatile int a = 0;
    volatile int b = 0;

    volatile int m = 0;
    volatile int n = 0;


    public void init() {
        a = 0;b = 0;m = 0;n = 0;
    }

    public void t_one(){
        a = 1;
        m = b;
    }

    public void t_two(){
        b = 1;
        n = a;
    }

    public void print(){
        if (m==n)
        System.out.println("m="+m+",n="+n);
    }

}
