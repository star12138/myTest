package pattern.observer.v1;

/**
 * @author
 * @create 2020-03-23 10:26 上午
 **/
public class ObserverTest {
    public static void main(String[] args) {
        GPer gPer = GPer.getInstance();

        Teacher teacher = new Teacher("tom");
        Teacher toney = new Teacher("toney");

        Question question = new Question("小明", "观察者模式适用于什么场景？");
        gPer.addObserver(teacher);
        gPer.addObserver(toney);
        gPer.pushQuestion(question);


    }
}
