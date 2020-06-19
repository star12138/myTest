package pattern.bridge;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 09:03
 * @Description:
 */
public class DepositAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开一个活期账户");
        return new DepositAccount();
    }

    @Override
    public void showAccount() {
        System.out.println("这是一个活期账户");
    }
}
