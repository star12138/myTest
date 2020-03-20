package concurrent.reenterLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author bike
 * @create 2019-07-30 11:03 AM
 *
 * 守护线程，用于清除死锁线程
 **/
public class DeadlockChecker {
    private final static ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
    final static Runnable deadlockCheck = () -> {
            while (true){
            long[] deadlockedThreads = mbean.findDeadlockedThreads();
            if (deadlockedThreads != null){
                ThreadInfo[] threadInfos = mbean.getThreadInfo(deadlockedThreads);
                for (Thread t : Thread.getAllStackTraces().keySet()){
                    for (int i = 0; i < threadInfos.length; i++){
                        if (t.getId() == threadInfos[i].getThreadId()){
                            t.interrupt();
                        }

                    }
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e){

                }
            }
        }
    };

    public static void check(){
        Thread t = new Thread(deadlockCheck);
        t.setDaemon(true);
        t.start();
    }
}
