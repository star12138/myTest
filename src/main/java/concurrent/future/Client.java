package concurrent.future;

/**
 * @author bike
 * @create 2019-08-15 2:55 PM
 **/
public class Client {
    public Data request(final String queryStr){
        final FutureData future = new FutureData();
        new Thread(){
            @Override
            public void run() {
                RealData data = new RealData(queryStr);
                future.setRealData(data);
            }
        }.start();
        return future;
    }

    public static void main(String[] args) {
        Client client = new Client();

        Data data = client.request("name");

        System.out.println("请求完毕");

        System.out.println("数据= " + data.getResult());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据= " + data.getResult());
    }
}
