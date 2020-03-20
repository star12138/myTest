package concurrent.producer_consumer;

import lombok.Data;

/**
 * @author bike
 * @create 2019-08-22 5:00 PM
 * 消费者
 **/
@Data
public class Consumer implements Runnable{
    private Stock s;

    @Override
    public void run() {
        s.consume();
    }
}
