package com.common.algorithm;

/**
 * 死锁案例
 */
public class DeadLockDemo {

    private static String locka="locka";
    private static String lockb="lockb";
    public void methodA(){
        synchronized (locka){
            System.out.println("我是A方法,我获得了A锁"+Thread.currentThread().getName());
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }synchronized (lockb){
            System.out.println("我是A方法,获取B锁成功"+Thread.currentThread().getName());
        }
    }

    public void methodB() {
        synchronized (lockb){
            System.out.println("我是B方法,我获得B锁"+Thread.currentThread().getName());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } synchronized (locka){
            System.out.println("我是B方法获取A锁成功"+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        DeadLockDemo deadLockDemo=new DeadLockDemo();
        new Thread(()->deadLockDemo.methodA()).start();
        new Thread(()->deadLockDemo.methodB()).start();
        System.out.println("运行完成"+Thread.currentThread().getName());
    }
}
