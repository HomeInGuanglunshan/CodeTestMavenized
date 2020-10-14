package lockTest.p01.read.write.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteLockTest {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
     
    public static void main(String[] args)  {
        final WriteLockTest test = new WriteLockTest();
         
        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();
         
        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();
         
    }  
     
    public void get(Thread thread) {
        rwl.writeLock().lock();
        try {
            long start = System.currentTimeMillis();
             
            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        } finally {
            rwl.writeLock().unlock();
        }
    }
}