package pattern.adapter.loginadapter.v2;

import pattern.adapter.ResultMsg;

public interface IPassportForThird {

    ResultMsg loginForQQ(String id);

    ResultMsg loginForWechat(String id);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelephone(String telphone, String code);

    ResultMsg loginForRegister(String userName, String passWord);
}
