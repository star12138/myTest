package pattern.adapter.loginadapter.v2.adapters;

import pattern.adapter.ResultMsg;

public interface LoginAdapter {
    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);

}
