package pattern.observer.v1;

import lombok.Data;

/**
 * @author
 * @create 2020-03-23 10:18 上午
 **/
@Data
public class Question {
    private String userName;

    private String cont;

    public Question(String userName, String cont) {
        this.userName = userName;
        this.cont = cont;
    }
}
