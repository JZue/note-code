package demo.thread.multithread.state;

/**
 * @author jzue
 * @date 2020/8/3 5:44 下午
 **/
public class ThreadStop {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.stop();
    }
}
