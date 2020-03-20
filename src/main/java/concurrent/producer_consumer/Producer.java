package concurrent.producer_consumer;

import lombok.Data;

/**
 * @author bike
 * @create 2019-08-22 4:59 PM
 * 生产者
 **/
@Data
public class Producer implements Runnable{
    private Stock s;

    @Override
    public void run() {
        s.produce();
    }
}
