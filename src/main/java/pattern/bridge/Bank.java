package pattern.bridge;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 09:04
 * @Description:
 */
public abstract class Bank {
    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract Account openAccount();
}
