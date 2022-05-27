package leetcode.editor.cn;

/**
 * 模拟死锁
 *
 * 死锁的四个必要条件:
 * 1. 资源互斥:一个资源同时只被一个线程占用
 * 2. 占有且等待:线程本身占有资源,同时在等待一个资源,此时不会放开本身占有的资源
 * 3. 不可抢占:不能强行获得已经被别的线程占用的资源
 * 4. 循环等待:若干线程由于等待下一个线程而形成环
 */
public class DeadLockDemo {

    //首先要两个资源
    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    public static void main(String[] args) {
        new Thread(
                ()->{
                    //线程A占用资源A
                    synchronized (resourceA){
                        System.out.println(Thread.currentThread() + "get resourceA");
                        //请求资源B的时候,要保证资源B被占用,所以这里先等待,保证线程B已经获取到资源B
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (resourceB) {
                            System.out.println(Thread.currentThread() + "get resourceB");
                        }
                    }
                },"线程A"
        ).start();
        new Thread(
                ()->{
                    //线程B占用资源B
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread() + "get resourceB");
                        synchronized (resourceA) {
                            System.out.println(Thread.currentThread() + "get resourceA");
                        }
                    }
                },"线程B"
        ).start();
    }

    /*
      避免死锁:
      1. 一次性申请所有资源
      2. 如果获取不到想要的资源, 可以先释放自己占有的资源
      3. 按一致的顺序去占用资源,比如本例中线程B可以先获取资源A再获取资源B
     */
}
