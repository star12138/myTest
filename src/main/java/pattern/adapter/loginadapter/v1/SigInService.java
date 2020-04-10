package pattern.adapter.loginadapter.v1;

import pattern.adapter.ResultMsg;

/**
 * @author
 * @create 2020-03-20 11:13 上午
 **/
public class SigInService {
    public ResultMsg register(String userName, String passWord){
        return new ResultMsg(200, "成功", null);
    }

    public ResultMsg login(String userName, String passWord){
        return null;
    }
}
