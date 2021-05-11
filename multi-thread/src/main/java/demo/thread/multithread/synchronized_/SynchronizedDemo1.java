package demo.thread.multithread.synchronized_;



/**
 * 成员变量作为synchronized的参数，Synchronized关键字不能生效
 * @author jzue
 * @date 2021/5/7 4:25 下午
 **/
public class SynchronizedDemo1 {
    public static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo1 synchronizedDemo1 = new SynchronizedDemo1();
        Thread thread1 = new Thread(() -> {
            for (int i=0;i<10000;i++){
                synchronizedDemo1.demo1();
            }
            System.out.println(num);
        });
        Thread thread2 = new Thread(() -> {
            for (int i=0;i<10000;i++){
                synchronizedDemo1.demo1();
            }
            System.out.println(num);
        });
        Thread thread3 = new Thread(() -> {
            for (int i=0;i<10000;i++){
                synchronizedDemo1.demo1();
            }
            System.out.println(num);
        });
        thread1.start();
        thread2.start();
        thread3.start();

    }

    void demo1(){
        SynchronizedDemo1 string = new SynchronizedDemo1();
        synchronized (Object.class){
            num++;
        }
    }
}
