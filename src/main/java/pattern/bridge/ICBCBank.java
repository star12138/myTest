package pattern.bridge;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 09:06
 * @Description:
 */
public class ICBCBank extends Bank{
    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("中国工商银行");
        account.openAccount();
        return account;
    }
}
