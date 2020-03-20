package concurrent.future;

import java.util.concurrent.Callable;

/**
 * @author bike
 * @create 2019-08-15 2:48 PM
 **/
public class RealData implements Data, Callable<String> {
    protected final String result;

    public RealData(String para) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public String call() throws Exception {
        return result;
    }
}
