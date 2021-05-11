package demo.thread.multithread.state;

/**
 *
 * thread1.join方法是阻塞持有对象锁的对象，让对应的线程(thread1)完成以后，被阻塞的线程才可以继续执行
 *
 *
 * 两个线程相继start() 进入Runnable状态，
 * 不确定哪一个线程获取cpu时间片？
 * 可能是Thread1,可能是Thread2,可能是Main，假设是Thread1
 * 然后到底是Thread2获取时间片，还是Main获取时间片呢？
 * 也不确定~
 * 但是可以肯定最后的那个输出肯定是main()
 * 总结就是，这样的使用join()跟本没有起到控制thread1和thread2的顺序的作用
 * @author jzue
 * @date 2020/7/24 10:23 上午
 **/
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0;i<10;i++){
            printOrderQuestion();
        }

    }
    static void printOrderQuestion()  {
        Thread thread1 = creator(1);
        Thread thread2 = creator(2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            thread1.interrupt();
        }
//        try {
//            thread2.join();
//        } catch (InterruptedException e) {
//            thread2.interrupt();
//        }
        System.out.println(Thread.currentThread().getName());
    }

    static void printOrderQuestion1()  {
        Thread thread1 = creator(1);
        Thread thread2 = creator(2);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            thread1.interrupt();
        }
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            thread2.interrupt();
        }
        System.out.println(Thread.currentThread().getName());
    }

    static Thread creator(int index){
        return new Thread(()->{
            System.out.println(index+"......:thread creator");
        });
    }
}
