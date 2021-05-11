package demo.thread.multithread.state;

/**
 * @author jzue
 * @date 2020/7/24 9:01 上午
 **/
public class ThreadYield {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 500; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                if (i%100  == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" +"让出cpu");
                    Thread.yield();
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5000; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                if (i %1000 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" +"让出cpu");
                    Thread.yield();
                }
            }
        }, "thread2");

        thread1.start();
        thread2.start();

    }
}
