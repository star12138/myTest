package pattern.observer.v1;

import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * @author
 * @create 2020-03-23 10:21 上午
 **/
@Data
public class Teacher implements Observer {
    private String userName;

    public Teacher(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gPer = (GPer) o;
        Question question = (Question) arg;

        System.out.println("=========================");
        System.out.println(this.userName + "老师您好\n" +
                "您收到一个来自" + gPer.getName() + "提问希望您解答，问题内容如下：\n" +
                question.getCont() + "\n" + "提问者：" + question.getUserName());

    }
}
