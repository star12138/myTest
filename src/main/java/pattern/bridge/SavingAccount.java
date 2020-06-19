package pattern.bridge;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 09:02
 * @Description:
 */
public class SavingAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开一个定期账户");
        return new SavingAccount();
    }

    @Override
    public void showAccount() {
        System.out.println("这是一个定期账户");
    }
}
