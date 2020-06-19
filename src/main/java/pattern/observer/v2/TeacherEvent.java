package pattern.observer.v2;

import com.google.common.eventbus.Subscribe;
import pattern.observer.v1.Question;

/**
 * @Auther: Administrator
 * @Date: 2020/6/1 16:37
 * @Description:
 */
public class TeacherEvent {
    private String name;

    public TeacherEvent(String name) {
        this.name = name;
    }

    @Subscribe
    public void subScribe(Question question) {
        System.out.println(this.name + "老师您好\n" +
                "您收到一个来自" + question.getPlatform() + "提问希望您解答，问题内容如下：\n" +
                question.getCont() + "\n" + "提问者：" + question.getUserName());
        System.out.println("=========================");
    }
}
