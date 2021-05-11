package demo.thread.multithread.juc.atomic;

import demo.thread.multithread.log.LogUtil;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * @author jzue
 * @date 2021/5/11 3:22 下午
 **/
public class LongAtomicDemo {
    public static void main(String[] args) {
        demoAtomicLong();
        demoAtomicLongArray();
        demoAtomicLongFieldUpdater();
    }

    public static void demoAtomicLong(){
        LogUtil.log4Start("demoAtomicInteger");
        // 默认 0
        AtomicLong atomicLong = new AtomicLong();
        //  +1
        long i = atomicLong.addAndGet(1);
        LogUtil.info("atomicInteger.addAndGet",i);
        LogUtil.log4End("demoAtomicInteger");
    }

    public static void demoAtomicLongArray(){
        LogUtil.log4Start("demoAtomicIntegerArray");
        // 复制array = [1,2]
        AtomicLongArray atomicLongArray = new AtomicLongArray(new long[]{1,2});
        // 设置index=0 的值为100,array = [100,2]
        atomicLongArray.set(0,100);
        LogUtil.info("index = 0 的值 add 1,array[0] = "+atomicLongArray.get(0));
        // index = 0 的值 add 1,array = [101,2]
        long i = atomicLongArray.addAndGet(0, 1);
        LogUtil.info("index = 0 的值 add 1,array[0] = "+i);
        LogUtil.log4End("demoAtomicIntegerArray");
    }

    public static void demoAtomicLongFieldUpdater(){
        LogUtil.log4Start("demoAtomicIntegerFieldUpdater");
        AtomicLongFieldUpdater<LongAtomicDemo.DemoEntity> demoEntityFliedAtomic = AtomicLongFieldUpdater.newUpdater(LongAtomicDemo.DemoEntity.class,"id");
        // int id 默认值 为 0
        LongAtomicDemo.DemoEntity demoEntity = new LongAtomicDemo.DemoEntity();

        long i = demoEntityFliedAtomic.addAndGet(demoEntity, 1);
        LogUtil.info("DemoEntity.id = "+demoEntity.getId());
        LogUtil.log4End("demoAtomicIntegerFieldUpdater");
    }

    static class DemoEntity{
        volatile  long id;
        private String key;
        public void setId(int id) {
            this.id= id;
        }
        public long getId() {
            return this.id;
        }
    }
}
