package pattern.delegate;

/**
 * @author bike
 * @create 2020-03-19 9:16 上午
 **/
public class EmployeeA implements Employee {
    @Override
    public void doing(String command) {
        System.out.println("员工A开始干活，擅长算法， 开始执行任务： " + command);
    }
}
