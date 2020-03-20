package pattern.delegate;

/**
 * @author bike
 * @create 2020-03-19 9:14 上午
 **/
public class Boss {
    public void command(String command, Leader leader) {
        leader.doing(command);
    }
}
