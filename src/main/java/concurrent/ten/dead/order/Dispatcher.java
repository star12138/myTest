package concurrent.ten.dead.order;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: Administrator
 * @Date: 2020/4/27 11:12
 * @Description:
 */
public class Dispatcher {
    private final Set<Taxi> taxis;
    private final Set<Taxi> availableTaxis;

    public Dispatcher() {
        taxis = new HashSet<>();
        availableTaxis = new HashSet<>();
    }
    
    public synchronized void notifyAvailable(Taxi taxi) {
        availableTaxis.add(taxi);
    }
    
    public synchronized Image getImage() {
        Image image = new Image();
        for (Taxi t : taxis) {
            image.drawMarker(t.getLocation());
        }
        return image;
    }

    // 开放调用
    public Image getImage2() {
        Set<Taxi> copy;
        synchronized (this) {
            copy = new HashSet<>(taxis);
        }

        Image image = new Image();
        for (Taxi t : copy) {
            image.drawMarker(t.getLocation());
        }
        return image;
    }
    
    class Image {

        public void drawMarker(Point location) {
        }
    }
}
