package com.alan.data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author linhyanyu
 * @description
 * @since 2024/11/25
 */
public class BinaryTest {

    public final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;

    private static int ctlOf(int rs, int wc) { return rs | wc; }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(1 << COUNT_BITS));
        System.out.println(Integer.toBinaryString((1 << 31)-1));
        BinaryTest binaryTest = new BinaryTest();
        System.out.println(Integer.toBinaryString(binaryTest.ctl.get()));
        System.out.println(Integer.toBinaryString(COUNT_BITS));
        System.out.println(Integer.toBinaryString(CAPACITY));
        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
    }

}
