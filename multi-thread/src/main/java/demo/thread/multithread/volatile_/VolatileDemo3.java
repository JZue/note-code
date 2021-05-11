package demo.thread.multithread.volatile_;

/**
 * volatile 和 防止指令重排序
 * @author jzue
 * @date 2021/4/25 4:07 下午
 **/
public class VolatileDemo3 {
    static int b,c;
    static boolean flag=false;

    static int LOOP_COUNT = 100;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {

            c = 10;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b = 10;
            System.out.println(b + c);


        });

        Thread thread2 = new Thread(() -> {
            System.out.println(b + c);

        });
        thread1.start();
        thread2.start();

    }
}
