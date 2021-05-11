package demo.thread.multithread.volatile_;

/**
 * volatile 与 原子性
 * example:
 * x=1;       //1 原子操作，给x赋值1
 * y=x;	   //2 非原子操作，取x的值，赋给y
 * y++;	   //3 取y的值，加1，赋给y
 * y=y+1;	   //4 类似与3
 *
 *
 *
 * 加了volatile，cpu会在每次操作对应的变量时，直接去操作main-memory（即常说的内存）的变量值
 *
 * 如果flag不加volatile,  new的Thread 走进第一个while (FLAG == 0)就会死循环，所以输出为
 * flag == 1
 * flag set end
 *
 * 如果flag 加了volatile， new的Thread 走进第一个while (FLAG == 0)，在感知到flag ==1 的时候会走进第二个循环，在flag==2 时会结束任务
 * 所以输出为
 * flag == 1
 * flag == 2
 * flag set end
 *
 * @author jzue
 * @date 2021/4/25 3:39 下午
 **/
public class VolatileDemo2 {

    public  static volatile int FLAG=0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            int num = 0;
            while (FLAG == 0){
                if (num == 0) {
                    System.out.println("flag == 1");
                    num ++;
                }
            }
            while (FLAG == 1){
                if (num == 1) {
                    System.out.println("flag == 2");
                    num++;
                }
            }

        }).start();


         Thread.sleep(1000);
        FLAG = 1;
         Thread.sleep(1000);
        FLAG = 2;
        // 最后这个sleep无实际意义，只是控制最后的这个flag set end输出在最后一个打印出来
        Thread.sleep(1000);
        System.out.println("flag set end");
    }
}
