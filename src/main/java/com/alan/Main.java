package com.alan;

/**
 * @author linhyanyu
 * @description
 * @since ${DATE}
 */
public class Main {
    private volatile long count=0;

    private synchronized void add10K(){
        int idx=0;
        while (idx++<10000){
            count+=1;
        }
    }

    public static long calc() throws InterruptedException {
        final Main main = new Main();
        Thread thread1 = new Thread(main::add10K);
        Thread thread2 = new Thread(main::add10K);

        thread1.start();
        thread2.start();
        System.out.println("count:"+main.count);
        main.count=1;

        thread1.join();
        System.out.println("count:"+main.count);
        thread2.join();
        System.out.println("count:"+main.count);
        return main.count;
    }


    public static void main(String[] args) {
        try {
            System.out.println(calc());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}