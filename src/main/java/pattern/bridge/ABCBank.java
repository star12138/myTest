package pattern.bridge;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 09:09
 * @Description:
 */
public class ABCBank extends Bank {
    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("中国农业银行");
        account.openAccount();
        return account;
    }
}
