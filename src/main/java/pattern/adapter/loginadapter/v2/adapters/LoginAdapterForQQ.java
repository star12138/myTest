package pattern.adapter.loginadapter.v2.adapters;

import pattern.adapter.ResultMsg;

/**
 * @author
 * @create 2020-03-20 11:44 上午
 **/
public class LoginAdapterForQQ implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginAdapterForQQ;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
