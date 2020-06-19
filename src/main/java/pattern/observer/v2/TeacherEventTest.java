package pattern.observer.v2;

import com.google.common.eventbus.EventBus;
import pattern.observer.v1.Question;

/**
 * @Auther: Administrator
 * @Date: 2020/6/1 16:45
 * @Description:
 */
public class TeacherEventTest {


    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        TeacherEvent teacherEvent = new TeacherEvent("geely");
        TeacherEvent teacherEvent2 = new TeacherEvent("bob");
        Question question = new Question("张三", "gPer", "观察者模式适用于什么场景？");
        Question question2 = new Question("李四", "gPer", "观察者模式适用于什么场景？");
        eventBus.register(teacherEvent);
        eventBus.register(teacherEvent2);

        eventBus.post(question);
        eventBus.post(question2);
    }
}
