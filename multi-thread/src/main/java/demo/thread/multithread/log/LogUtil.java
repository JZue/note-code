package demo.thread.multithread.log;


import static java.text.MessageFormat.*;

/**
 * @author jzue
 * @date 2021/5/11 4:05 下午
 **/
public class LogUtil {


    public static void log4Start(String method){
        System.out.println(format("start 【{0}】", method));
    }
    public static void log4End(String method){
        System.out.println(format("end 【{0}】", method));
        System.out.println();
    }
    public static void info(String msg){
        System.out.println(msg);
    }
    public static void info(String area,Object msg){
        System.out.println(area+"=====>:"+msg);
    }

}
