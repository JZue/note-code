package demo.thread.multithread.volatile_;

/**
 * volatile与静态变量的可见性问题
 * @author jzue
 * @date 2021/4/25 3:35 下午
 **/
public class VolatileDemo1 {
    public  static  boolean flag=false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (!flag){ }
            System.out.println("single core is true:");
        }).start();
        // sleep 一秒，确保，主线程的任务和子线程的任务不分配到同一个cpu
        // 如果不sleep一秒，则有可能被分配到同一个cpu上，那么volatile的可见性的问题没有了
//         Thread.sleep(1000);
        flag = true;
        System.out.println("flag set end");
    }
}
