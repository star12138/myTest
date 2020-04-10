package pattern.adapter.loginadapter.v2.adapters;

import pattern.adapter.ResultMsg;

/**
 * @author
 * @create 2020-03-20 11:47 上午
 **/
public class LoginAdapterForToken implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginAdapterForToken;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
