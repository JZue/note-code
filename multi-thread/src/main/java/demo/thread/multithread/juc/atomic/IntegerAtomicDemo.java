package demo.thread.multithread.juc.atomic;

import demo.thread.multithread.log.LogUtil;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicInteger
 * AtomicIntegerArray
 * AtomicIntegerFieldUpdater 基于反射的实用工具，可以对指定类的指定 volatile int 字段进行原子更新
 *
 * @author jzue
 * @date 2021/5/11 3:13 下午
 **/
public class IntegerAtomicDemo {

    public static void main(String[] args) {
        demoAtomicInteger();
        demoAtomicIntegerArray();
        demoAtomicIntegerFieldUpdater();
    }

    public static void demoAtomicInteger(){
        LogUtil.log4Start("demoAtomicInteger");
        // 默认 0
        AtomicInteger atomicInteger = new AtomicInteger();
        //  +1
        int i = atomicInteger.addAndGet(1);
        LogUtil.info("atomicInteger.addAndGet",i);
        LogUtil.log4End("demoAtomicInteger");
    }

    public static void demoAtomicIntegerArray(){
        LogUtil.log4Start("demoAtomicIntegerArray");
        // 复制array = [1,2]
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{1,2});
        // 设置index=0 的值为100,array = [100,2]
        atomicIntegerArray.set(0,100);
        LogUtil.info("index = 0 的值 add 1,array[0] = "+atomicIntegerArray.get(0));
        // index = 0 的值 add 1,array = [101,2]
        int i = atomicIntegerArray.addAndGet(0, 1);
        LogUtil.info("index = 0 的值 add 1,array[0] = "+i);
        LogUtil.log4End("demoAtomicIntegerArray");
    }

    public static void demoAtomicIntegerFieldUpdater(){
        LogUtil.log4Start("demoAtomicIntegerFieldUpdater");
        AtomicIntegerFieldUpdater<DemoEntity> demoEntityFliedAtomic = AtomicIntegerFieldUpdater.newUpdater(DemoEntity.class,"id");
        // int id 默认值 为 0
        DemoEntity demoEntity = new DemoEntity();

        int i = demoEntityFliedAtomic.addAndGet(demoEntity, 1);
        LogUtil.info("DemoEntity.id = "+demoEntity.getId());
        LogUtil.log4End("demoAtomicIntegerFieldUpdater");
    }

    static class DemoEntity{
        volatile  int id;
        private String key;
        public void setId(int id) {
            this.id= id;
        }
        public int getId() {
            return this.id;
        }
    }


}
