package pattern.adapter.loginadapter.v2;

import pattern.adapter.ResultMsg;
import pattern.adapter.loginadapter.v1.SigInService;
import pattern.adapter.loginadapter.v2.adapters.LoginAdapter;
import pattern.adapter.loginadapter.v2.adapters.LoginAdapterForQQ;
import pattern.adapter.loginadapter.v2.adapters.LoginAdapterForToken;

/**
 * @author
 * @create 2020-03-20 11:31 上午
 **/
public class PassportForThirdAdapter extends SigInService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLoginAdapter(id, LoginAdapterForQQ.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLoginAdapter(token, LoginAdapterForToken.class);
    }

    @Override
    public ResultMsg loginForTelephone(String telephone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegister(String userName, String passWord) {
        return super.register(userName, passWord);
    }

    public ResultMsg processLoginAdapter(String id, Class<? extends LoginAdapter> clazz) {
        try {
            LoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)) {
                adapter.login(id, adapter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
