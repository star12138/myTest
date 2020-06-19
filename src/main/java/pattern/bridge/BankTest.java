package pattern.bridge;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 09:10
 * @Description:
 */
public class BankTest {
    public static void main(String[] args) {
        Bank icbcBank = new ICBCBank(new SavingAccount());
        Account icbcAccount = icbcBank.openAccount();
        icbcAccount.showAccount();

        Bank abcBank = new ABCBank(new DepositAccount());
        Account abcAccount = abcBank.openAccount();
        abcAccount.showAccount();
    }
}
