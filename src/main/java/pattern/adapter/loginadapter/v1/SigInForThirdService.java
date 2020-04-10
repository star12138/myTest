package pattern.adapter.loginadapter.v1;

import pattern.adapter.ResultMsg;

/**
 * @author bike
 * @create 2020-03-20 11:19 上午
 **/
public class SigInForThirdService extends SigInService {

    public ResultMsg loginForQQ(String openId) {
        return loginForRegist(openId, null);
    }

    private ResultMsg loginForRegist(String userName, String passWord) {
        return super.register(userName, null);
    }

    public ResultMsg loginForWechat(String openId) {
        return null;
    }

    public ResultMsg loginForTelphone(String openId) {
        return null;
    }

    public ResultMsg loginForToken(String openId) {
        return null;
    }
}
