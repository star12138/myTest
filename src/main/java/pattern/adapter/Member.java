package pattern.adapter;

/**
 * @author
 * @create 2020-03-20 11:11 上午
 **/

public class Member {
    private String userName;
    private String passWord;
    private String mid;
    private String info;

    public Member(String userName, String passWord, String mid, String info) {
        this.userName = userName;
        this.passWord = passWord;
        this.mid = mid;
        this.info = info;
    }
}
