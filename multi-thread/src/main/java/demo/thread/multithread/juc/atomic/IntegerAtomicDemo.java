package demo.thread.multithread.juc.atomic;

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

    }

    public static void demoAtomicInteger(){

    }

    public static void demoAtomicIntegerArray(){

    }

    public static void demoAtomicIntegerFieldUpdater(){
        AtomicIntegerFieldUpdater<DemoEntity> demoEntityFliedAtomic = AtomicIntegerFieldUpdater.newUpdater(DemoEntity.class,"id");
        DemoEntity demoEntity = new DemoEntity();

        demoEntityFliedAtomic.addAndGet(demoEntity,1);
        // 其他方法，用的时候一一看
    }

    static class DemoEntity{
        private volatile  int id;
        private String key;
        public void setId(int id) {
            this.id= id;
        }
        public int getId() {
            return this.id;
        }
    }


}
