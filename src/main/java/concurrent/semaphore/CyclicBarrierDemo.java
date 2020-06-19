package concurrent.semaphore;

import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: Administrator
 * @Date: 2020/5/4 14:59
 * @Description:
 */
public class CyclicBarrierDemo extends Thread {

    @Override
    public void run() {
        System.out.println("数据导入完毕， 开始解析数据");
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CyclicBarrierDemo());
//        new DataImportThread(cyclicBarrier, "file1").start();
//        new DataImportThread(cyclicBarrier, "file2").start();
//        new DataImportThread(cyclicBarrier, "file3").start();
    }
}
