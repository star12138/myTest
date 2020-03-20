package pattern.delegate;

import java.util.HashMap;

/**
 * @author bike
 * @create 2020-03-19 9:15 上午
 **/
public class Leader {

    private HashMap<String, Employee> register = new HashMap<>();

    public Leader() {
        register.put("算法", new EmployeeA());
        register.put("架构", new EmployeeB());
    }

    public void doing(String command) {
        register.get(command).doing(command);
    }
}
