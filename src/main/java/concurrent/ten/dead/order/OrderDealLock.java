package concurrent.ten.dead.order;

import lombok.Data;

import javax.naming.ldap.Rdn;
import java.math.BigDecimal;
import java.util.Random;

/**
 * @Auther: Administrator
 * @Date: 2020/4/27 10:27
 * @Description: 顺序死锁
 */
public class OrderDealLock {

    /**
     * 会出现死锁，不可控的 fromAccount 与 toAccount
     * 同=同时有两个线程 x-y转钱 与 y-x转钱
     * @param fromAccount
     * @param toAccount
     * @param amount
     */
    public static void transferMoney(Account fromAccount,
                              Account toAccount,
                              BigDecimal amount){
        synchronized (fromAccount) {
            synchronized (toAccount) {
                if (fromAccount.getAmount().compareTo(amount) < 0) {
                    // 金额不足
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
    }

    private static final Object tieLock = new Object();

    /**
     * 通过对象的hash确定了锁的顺序，
     * 但是极少数的情况下，两个对象具有相同的哈希码。我们必须使用任意的
     * ‘中数’来决定锁的顺序，这又重新引入了死锁的可能性，所以引入了第三种"加时赛"锁
     *
     * @param fromAccount
     * @param toAccount
     * @param amount
     */
    public static void transferMoney2(Account fromAccount,
                              Account toAccount,
                              BigDecimal amount){
        class Helper {
            public void transfer() {
                if (fromAccount.getAmount().compareTo(amount) < 0) {
                    // 金额不足
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);
        if (fromHash < toHash) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

    @Data
    public static class Account {
        BigDecimal amount;

        public Account() {
            amount = BigDecimal.ZERO;
        }

        private void debit(BigDecimal amount) {
            amount = amount.subtract(amount);
        }

        private void credit(BigDecimal amount) {
            amount = amount.add(amount);
        }
    }


    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 20;
    private static final int NUM_ITERATIONS = 20;

    public static void main(String[] args) {
        final Random rnd = new Random();
        final Account[] accounts = new Account[NUM_ACCOUNTS];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
        }

        class TransferThread extends Thread {
            public void run() {
                for (int i = 0; i < NUM_ITERATIONS; i++) {
                    int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int toAcct = rnd.nextInt(NUM_ACCOUNTS);
                    BigDecimal amount = new BigDecimal(rnd.nextInt(1000));
                    transferMoney2(accounts[fromAcct], accounts[toAcct], amount);
                }
            }
        }
        for (int i = 0; i < NUM_THREADS; i ++) {
            new TransferThread().start();
        }

    }

}
