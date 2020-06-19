package pattern.observer.guavaevent;

import com.google.common.eventbus.EventBus;

/**
 * @Auther: Administrator
 * @Date: 2020/6/1 16:26
 * @Description:
 */
public class GuavaEventTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();

        eventBus.register(guavaEvent);
        eventBus.post("post内容");
    }
}
