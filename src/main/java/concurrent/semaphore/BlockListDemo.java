package concurrent.semaphore;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/4 19:04
 * @Description:
 */
public class BlockListDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockList<Integer> list = new BlockList<>();
        new Customer(list).start();
        new Provider(list).start();
        new Provider(list).start();
        new Provider(list).start();

    }

   static class Customer extends Thread {
        BlockList list;
        public Customer(BlockList list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i=0; i < 100; i++) {
                try {
                    if (list.put(i)) {
                        System.out.println("存放数据成功，当前元素： " + i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Provider extends Thread {
        BlockList list;
        public Provider(BlockList list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i=0; i < 100; i++) {
                try {
                    System.out.println("读取数据成功，当前元素： " + list.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
