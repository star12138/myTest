package pattern.observer.v1;

import java.util.Observable;

/**
 * @author
 * @create 2020-03-23 10:15 上午
 **/
public class GPer extends Observable {
    private String name = "gPer生态圈";
    private static GPer gPer = null;

    private GPer() {
    }

    public static GPer getInstance() {
        if (gPer == null) {
            gPer = new GPer();
        }
        return gPer;
    }

    public String getName() {
        return name;
    }

    public void pushQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
