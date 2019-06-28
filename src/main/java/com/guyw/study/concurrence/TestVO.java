package com.guyw.study.concurrence;

import java.util.concurrent.atomic.AtomicInteger;

public class TestVO {
    private Integer ss;
    private int a ;
    private AtomicInteger b;
    private long c;

    public Integer getSs() {
        return ss;
    }

    public void setSs(Integer ss) {
        this.ss = ss;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public AtomicInteger getB() {
        return b;
    }

    public void setB(AtomicInteger b) {
        this.b = b;
    }

    public long getC() {
        return c;
    }

    public void setC(long c) {
        this.c = c;
    }
}
