package demo.thread.multithread.state;

/**
 * @author jzue
 * @date 2020/7/24 8:46 上午
 **/
public class StateDemo1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            System.out.println(11);
        });
        Thread thread2 = new Thread(()->{
            System.out.println(22);
        });

        thread1.start();
        thread2.start();
        while (true){
            System.out.println("THread1:"+thread1.getState());
            System.out.println("THread2:"+thread2.getState());
            if (thread1.getState().equals(Thread.State.TERMINATED)&&
                    thread2.getState().equals(Thread.State.TERMINATED)){
                break;
            }
        }

    }
}
