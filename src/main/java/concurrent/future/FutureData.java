package concurrent.future;

/**
 * @author bike
 * @create 2019-08-15 2:51 PM
 **/
public class FutureData implements Data {
    protected RealData realData = null;
    protected boolean isReady = false;
    public synchronized void setRealData(RealData realData){
        if (isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    @Override
    public String getResult() {
        while (!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.result;
    }
}
