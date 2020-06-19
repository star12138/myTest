package pattern.observer.guavaevent;

import com.google.common.eventbus.Subscribe;
import pattern.observer.v1.Question;

/**
 * @Auther: Administrator
 * @Date: 2020/6/1 16:23
 * @Description:
 */
public class GuavaEvent {

    @Subscribe
    public void subScribe(Question string) {
        System.out.println("传递过来的参数： " + string);
    }
}
